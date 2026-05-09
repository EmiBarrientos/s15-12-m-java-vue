package com.nc.Propiedades360.app.visita.service;

import com.nc.Propiedades360.app.cliente.entity.Cliente;
import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
import com.nc.Propiedades360.app.inmueble.service.InmuebleService;
import com.nc.Propiedades360.app.visita.entity.Visita;
import com.nc.Propiedades360.app.visita.repository.VisitaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VisitaServiceTest {

    @Mock private VisitaRepository visitaRepository;
    @Mock private InmuebleService inmuebleService;

    @InjectMocks
    private VisitaService visitaService;

    private Visita visita;
    private Cliente cliente;
    private Inmueble inmueble;

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Juan Pérez");

        inmueble = new Inmueble();
        inmueble.setId(1L);
        inmueble.setTitulo("Casa en Palermo");

        visita = new Visita();
        visita.setId(1L);
        visita.setFechaVisita(LocalDate.now());
        visita.setCliente(cliente);
        visita.setInmueble(inmueble);
    }

    // --- findAll ---

    @Test
    void findAll_retornaListaDeVisitas() {
        when(visitaRepository.findAll()).thenReturn(List.of(visita));

        List<Visita> resultado = visitaService.findAll();

        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
        verify(visitaRepository, times(1)).findAll();
    }

    // --- findById ---

    @Test
    void findById_idExiste_retornaVisita() {
        when(visitaRepository.findById(1L)).thenReturn(Optional.of(visita));

        Visita resultado = visitaService.findById(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
    }

    @Test
    void findById_idNoExiste_lanzaExcepcion() {
        when(visitaRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> visitaService.findById(99L)
        );
    }

    // --- crearVisita ---

    @Test
    void crearVisita_datosValidos_guardaVisita() {
        when(visitaRepository.save(visita)).thenReturn(visita);

        Visita resultado = visitaService.crearVisita(visita);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        verify(visitaRepository, times(1)).save(visita);
    }

    // --- actualizarVisita ---

    @Test
    void actualizarVisita_visitaExiste_actualizaCampos() {
        Visita detalles = new Visita();
        detalles.setId(1L);
        detalles.setFechaVisita(LocalDate.now().plusDays(3));
        detalles.setCliente(cliente);
        detalles.setInmueble(inmueble);

        when(visitaRepository.findById(1L)).thenReturn(Optional.of(visita));
        when(visitaRepository.save(visita)).thenReturn(visita);

        Visita resultado = visitaService.actualizarVisita(detalles);

        assertEquals(LocalDate.now().plusDays(3), resultado.getFechaVisita());
        verify(visitaRepository, times(1)).save(visita);
    }

    @Test
    void actualizarVisita_visitaNoExiste_lanzaExcepcion() {
        Visita detalles = new Visita();
        detalles.setId(99L);

        when(visitaRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> visitaService.actualizarVisita(detalles)
        );

        verify(visitaRepository, never()).save(any());
    }

    // --- eliminarVisita ---

    @Test
    void eliminarVisita_eliminaCorrectamente() {
        visitaService.eliminarVisita(1L);

        verify(visitaRepository, times(1)).deleteById(1L);
    }
}