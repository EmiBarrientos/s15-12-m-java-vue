package com.nc.Propiedades360.app.propietario.service;

import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
import com.nc.Propiedades360.app.inmueble.enums.EstadoInmueble;
import com.nc.Propiedades360.app.inmueble.service.InmuebleService;
import com.nc.Propiedades360.app.propietario.entity.Propietario;
import com.nc.Propiedades360.app.propietario.repository.PropietarioRepository;
import com.nc.Propiedades360.app.usuario.enums.Rol;
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
public class PropietarioServiceTest {

    @Mock private PropietarioRepository propietarioRepository;
    @Mock private InmuebleService inmuebleService;

    @InjectMocks
    private PropietarioService propietarioService;

    private Propietario propietario;
    private Inmueble inmueble;

    @BeforeEach
    void setUp() {
        propietario = new Propietario();
        propietario.setId(1L);
        propietario.setNombre("María García");
        propietario.setEmail("maria.garcia@email.com");
        propietario.setContrasena("Password123!");
        propietario.setTelefono("1187654321");

        inmueble = new Inmueble();
        inmueble.setId(1L);
        inmueble.setTitulo("Casa en Palermo");
        inmueble.setUbicacion("Palermo, CABA");
        inmueble.setPrecio(150000.0);
        inmueble.setEstado(EstadoInmueble.DISPONIBLE);
    }

    // --- savePropietario ---

    @Test
    void savePropietario_datosValidos_asignaRolYGuarda() {
        when(propietarioRepository.save(propietario)).thenReturn(propietario);

        Propietario resultado = propietarioService.savePropietario(propietario);

        assertNotNull(resultado);
        assertEquals(Rol.PROPIETARIO, resultado.getRol());
        verify(propietarioRepository, times(1)).save(propietario);
    }

    // --- getPropietarioById ---

    @Test
    void getPropietarioById_idExiste_retornaPropietario() {
        when(propietarioRepository.findById(1L)).thenReturn(Optional.of(propietario));

        Propietario resultado = propietarioService.getPropietarioById(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
    }

    @Test
    void getPropietarioById_idNoExiste_lanzaExcepcion() {
        when(propietarioRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> propietarioService.getPropietarioById(99L)
        );
    }

    // --- getInmueblesByPropietario ---

    @Test
    void getInmueblesByPropietario_propietarioExiste_retornaInmuebles() {
        propietario.setInmuebles(List.of(inmueble));
        when(propietarioRepository.findById(1L)).thenReturn(Optional.of(propietario));

        List<Inmueble> resultado = propietarioService.getInmueblesByPropietario(1L);

        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
    }

    @Test
    void getInmueblesByPropietario_propietarioNoExiste_lanzaExcepcion() {
        when(propietarioRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> propietarioService.getInmueblesByPropietario(99L)
        );
    }

    // --- publicarInmueble ---

    @Test
    void publicarInmueble_propietarioExiste_guardaInmuebleDisponible() {
        when(propietarioRepository.findById(1L)).thenReturn(Optional.of(propietario));
        when(inmuebleService.save(inmueble)).thenReturn(inmueble);

        Inmueble resultado = propietarioService.publicarInmueble(inmueble, 1L);

        assertNotNull(resultado);
        assertEquals(propietario, resultado.getPropietario());
        assertEquals(EstadoInmueble.DISPONIBLE, resultado.getEstado());
        verify(inmuebleService, times(1)).save(inmueble);
    }

    @Test
    void publicarInmueble_propietarioNoExiste_lanzaExcepcion() {
        when(propietarioRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> propietarioService.publicarInmueble(inmueble, 99L)
        );

        verify(inmuebleService, never()).save(any());
    }

    // --- actualizarInmueble ---

    @Test
    void actualizarInmueble_inmuebleExiste_actualizaCampos() {
        Inmueble detalles = new Inmueble();
        detalles.setTitulo("Casa en Belgrano");
        detalles.setUbicacion("Belgrano, CABA");
        detalles.setPrecio(200000.0);

        when(inmuebleService.findById(1L)).thenReturn(inmueble);
        when(inmuebleService.save(inmueble)).thenReturn(inmueble);

        Inmueble resultado = propietarioService.actualizarInmueble(1L, detalles);

        assertEquals("Casa en Belgrano", resultado.getTitulo());
        assertEquals("Belgrano, CABA", resultado.getUbicacion());
        assertEquals(200000.0, resultado.getPrecio());
        verify(inmuebleService, times(1)).save(inmueble);
    }

    @Test
    void actualizarInmueble_inmuebleNoExiste_lanzaExcepcion() {
        when(inmuebleService.findById(99L)).thenThrow(
                new ResourceNotFoundException("Inmueble no encontrado")
        );

        assertThrows(ResourceNotFoundException.class,
                () -> propietarioService.actualizarInmueble(99L, inmueble)
        );

        verify(inmuebleService, never()).save(any());
    }

    // --- eliminarInmueble ---

    @Test
    void eliminarInmueble_inmuebleExiste_eliminaCorrectamente() {
        propietarioService.eliminarInmueble(1L);

        verify(inmuebleService, times(1)).deleteById(1L);
    }
}