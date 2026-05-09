package com.nc.Propiedades360.app.inmueble.service;

import com.nc.Propiedades360.app.exception.ResourceNotAvailableException;
import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
import com.nc.Propiedades360.app.inmueble.enums.EstadoInmueble;
import com.nc.Propiedades360.app.inmueble.repository.InmuebleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InmuebleServiceTest {

    @Mock
    private InmuebleRepository inmuebleRepository;

    @InjectMocks
    private InmuebleService inmuebleService;

    private Inmueble inmueble;

    @BeforeEach
    void setUp() {
        inmueble = new Inmueble();
        inmueble.setId(1L);
        inmueble.setTitulo("Casa en Palermo");
        inmueble.setUbicacion("Palermo, CABA");
        inmueble.setPrecio(150000.0);
        inmueble.setEstado(EstadoInmueble.DISPONIBLE);
    }

    // --- findAll ---

    @Test
    void findAll_retornaListaDeInmuebles() {
        when(inmuebleRepository.findAll()).thenReturn(List.of(inmueble));

        List<Inmueble> resultado = inmuebleService.findAll();

        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
        verify(inmuebleRepository, times(1)).findAll();
    }

    // --- findById ---

    @Test
    void findById_idExiste_retornaInmueble() {
        when(inmuebleRepository.findById(1L)).thenReturn(Optional.of(inmueble));

        Inmueble resultado = inmuebleService.findById(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
    }

    @Test
    void findById_idNoExiste_lanzaExcepcion() {
        when(inmuebleRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> inmuebleService.findById(99L)
        );
    }

    // --- save ---

    @Test
    void save_inmuebleNuevo_setaDisponibleYguarda() {
        when(inmuebleRepository.save(inmueble)).thenReturn(inmueble);

        Inmueble resultado = inmuebleService.save(inmueble);

        assertNotNull(resultado);
        assertEquals(EstadoInmueble.DISPONIBLE, resultado.getEstado());
        verify(inmuebleRepository, times(1)).save(inmueble);
    }

    // --- deleteById ---

    @Test
    void deleteById_eliminaInmueble() {
        inmuebleService.deleteById(1L);

        verify(inmuebleRepository, times(1)).deleteById(1L);
    }

    // --- verificarDisponibilidad ---

    @Test
    void verificarDisponibilidad_inmuebleDisponible_retornaInmueble() {
        when(inmuebleRepository.findById(1L)).thenReturn(Optional.of(inmueble));

        Inmueble resultado = inmuebleService.verificarDisponibilidad(1L);

        assertNotNull(resultado);
        assertEquals(EstadoInmueble.DISPONIBLE, resultado.getEstado());
    }

    @Test
    void verificarDisponibilidad_inmuebleNoDisponible_lanzaExcepcion() {
        inmueble.setEstado(EstadoInmueble.RESERVADO);
        when(inmuebleRepository.findById(1L)).thenReturn(Optional.of(inmueble));

        assertThrows(ResourceNotAvailableException.class,
                () -> inmuebleService.verificarDisponibilidad(1L)
        );
    }

    // --- actualizarEstado ---

    @Test
    void actualizarEstado_inmuebleExiste_actualizaEstado() {
        when(inmuebleRepository.findById(1L)).thenReturn(Optional.of(inmueble));
        when(inmuebleRepository.save(inmueble)).thenReturn(inmueble);

        Inmueble resultado = inmuebleService.actualizarEstado(1L, EstadoInmueble.RESERVADO);

        assertEquals(EstadoInmueble.RESERVADO, resultado.getEstado());
        verify(inmuebleRepository, times(1)).save(inmueble);
    }

    @Test
    void actualizarEstado_inmuebleNoExiste_lanzaExcepcion() {
        when(inmuebleRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> inmuebleService.actualizarEstado(99L, EstadoInmueble.RESERVADO)
        );

        verify(inmuebleRepository, never()).save(any());
    }
}