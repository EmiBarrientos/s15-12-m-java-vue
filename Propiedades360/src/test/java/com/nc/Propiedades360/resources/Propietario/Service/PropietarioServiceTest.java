package com.nc.Propiedades360.resources.Propietario.Service;

import com.nc.Propiedades360.resources.Propietario.Entity.Propietario;
import com.nc.Propiedades360.resources.Propietario.Repository.PropietarioRepository;
import com.nc.Propiedades360.resources.Usuario.enums.Rol;
import com.nc.Propiedades360.resources.inmueble.entity.Inmueble;
import com.nc.Propiedades360.resources.inmueble.repository.InmuebleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropietarioServiceTest {

    @Mock
    private PropietarioRepository propietarioRepository;

    @Mock
    private InmuebleRepository inmuebleRepository;

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

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> propietarioService.getPropietarioById(99L)
        );

        assertEquals("Propietario no encontrado", ex.getMessage());
    }

    // --- publicarInmueble ---

    @Test
    void publicarInmueble_propietarioExiste_guardaInmueble() {
        when(propietarioRepository.findById(1L)).thenReturn(Optional.of(propietario));
        when(inmuebleRepository.save(inmueble)).thenReturn(inmueble);

        Inmueble resultado = propietarioService.publicarInmueble(inmueble, 1L);

        assertNotNull(resultado);
        assertEquals(propietario, resultado.getPropietario());
        verify(inmuebleRepository, times(1)).save(inmueble);
    }

    @Test
    void publicarInmueble_propietarioNoExiste_lanzaExcepcion() {
        when(propietarioRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> propietarioService.publicarInmueble(inmueble, 99L)
        );

        assertEquals("Propietario no encontrado", ex.getMessage());
        verify(inmuebleRepository, never()).save(any());
    }

    // --- actualizarInmueble ---

    @Test
    void actualizarInmueble_inmuebleExiste_actualizaCampos() {
        Inmueble detalles = new Inmueble();
        detalles.setTitulo("Casa en Belgrano");
        detalles.setUbicacion("Belgrano, CABA");
        detalles.setPrecio(200000.0);

        when(inmuebleRepository.findById(1L)).thenReturn(Optional.of(inmueble));
        when(inmuebleRepository.save(inmueble)).thenReturn(inmueble);

        Inmueble resultado = propietarioService.actualizarInmueble(1L, detalles);

        assertEquals("Casa en Belgrano", resultado.getTitulo());
        assertEquals("Belgrano, CABA", resultado.getUbicacion());
        assertEquals(200000.0, resultado.getPrecio());
        verify(inmuebleRepository, times(1)).save(inmueble);
    }

    @Test
    void actualizarInmueble_inmuebleNoExiste_lanzaExcepcion() {
        when(inmuebleRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> propietarioService.actualizarInmueble(99L, inmueble)
        );

        assertEquals("Inmueble no encontrado", ex.getMessage());
        verify(inmuebleRepository, never()).save(any());
    }

    // --- eliminarInmueble ---

    @Test
    void eliminarInmueble_inmuebleExiste_eliminaCorrectamente() {
        when(inmuebleRepository.findById(1L)).thenReturn(Optional.of(inmueble));

        propietarioService.eliminarInmueble(1L);

        verify(inmuebleRepository, times(1)).delete(inmueble);
    }

    @Test
    void eliminarInmueble_inmuebleNoExiste_lanzaExcepcion() {
        when(inmuebleRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> propietarioService.eliminarInmueble(99L)
        );

        assertEquals("Inmueble no encontrado", ex.getMessage());
        verify(inmuebleRepository, never()).delete(any());
    }
}