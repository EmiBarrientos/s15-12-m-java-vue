package com.nc.Propiedades360.app.usuario.service;

import com.nc.Propiedades360.app.usuario.entity.Usuario;
import com.nc.Propiedades360.app.usuario.repository.UsuarioRepository;
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
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Juan Pérez");
        usuario.setEmail("juan.perez@email.com");
        usuario.setContrasena("Password123!");
        usuario.setTelefono("1134567890");
    }

    // --- iniciarSesion ---

    @Test
    void iniciarSesion_credencialesCorrectas_retornaUsuario() {
        when(usuarioRepository.findByEmail("juan.perez@email.com"))
                .thenReturn(Optional.of(usuario));

        Optional<Usuario> resultado = usuarioService.iniciarSesion(
                "juan.perez@email.com", "Password123!"
        );

        assertTrue(resultado.isPresent());
        assertEquals("juan.perez@email.com", resultado.get().getEmail());
    }

    @Test
    void iniciarSesion_contrasenaIncorrecta_retornaVacio() {
        when(usuarioRepository.findByEmail("juan.perez@email.com"))
                .thenReturn(Optional.of(usuario));

        Optional<Usuario> resultado = usuarioService.iniciarSesion(
                "juan.perez@email.com", "contrasenaMal"
        );

        assertTrue(resultado.isEmpty());
    }

    @Test
    void iniciarSesion_emailNoExiste_retornaVacio() {
        when(usuarioRepository.findByEmail("noexiste@email.com"))
                .thenReturn(Optional.empty());

        Optional<Usuario> resultado = usuarioService.iniciarSesion(
                "noexiste@email.com", "Password123!"
        );

        assertTrue(resultado.isEmpty());
    }

    // --- actualizarPerfil ---

    @Test
    void actualizarPerfil_usuarioExiste_retornaUsuarioActualizado() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario resultado = usuarioService.actualizarPerfil(usuario);

        assertNotNull(resultado);
        assertEquals("Juan Pérez", resultado.getNombre());
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void actualizarPerfil_usuarioNoExiste_retornaNull() {
        when(usuarioRepository.findById(1L)).thenReturn(Optional.empty());

        Usuario resultado = usuarioService.actualizarPerfil(usuario);

        assertNull(resultado);
        verify(usuarioRepository, never()).save(any());
    }
}