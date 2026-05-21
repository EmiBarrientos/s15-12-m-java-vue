package com.nc.Propiedades360.app.usuario.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.auth.dto.LoginRequest;
import com.nc.Propiedades360.app.usuario.entity.Usuario;
import com.nc.Propiedades360.app.usuario.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UsuarioService usuarioService;

    private Usuario usuario;
    private LoginRequest loginRequest;

    @BeforeEach
    void setUp() {
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Juan Pérez");
        usuario.setEmail("juan.perez@email.com");
        usuario.setContrasena("Password123!");
        usuario.setTelefono("1134567890");

        loginRequest = new LoginRequest();
        loginRequest.setUsername("juan.perez");
        loginRequest.setContrasena("Password123!");
    }

    // --- iniciarSesion ---

  /*  @Test
   void iniciarSesion_credencialesCorrectas_retorna200() throws Exception {
        when(usuarioService.iniciarSesion("juan.perez@email.com", "Password123!"))
                .thenReturn(Optional.of(usuario));

        mockMvc.perform(post("/usuarios/iniciar-sesion")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("juan.perez@email.com"));
    }

    @Test
    void iniciarSesion_credencialesIncorrectas_retorna404() throws Exception {
        when(usuarioService.iniciarSesion("juan.perez@email.com", "Password123!"))
                .thenReturn(Optional.empty());

        mockMvc.perform(post("/usuarios/iniciar-sesion")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginDto)))
                .andExpect(status().isNotFound());
    }
*/
    // --- actualizarPerfil ---

    @Test
    void actualizarPerfil_usuarioExiste_retorna200() throws Exception {
        when(usuarioService.actualizarPerfil(any(Usuario.class))).thenReturn(usuario);

        mockMvc.perform(put("/usuarios/actualizar-perfil")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Juan Pérez"));
    }

    @Test
    void actualizarPerfil_usuarioNoExiste_retorna404() throws Exception {
        when(usuarioService.actualizarPerfil(any(Usuario.class)))
                .thenThrow(new ResourceNotFoundException("Usuario no encontrado"));

        mockMvc.perform(put("/usuarios/actualizar-perfil")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Usuario no encontrado"));
    }
}