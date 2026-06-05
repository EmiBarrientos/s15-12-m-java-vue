package com.nc.Propiedades360.app.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nc.Propiedades360.app.auth.dto.AuthResponse;
import com.nc.Propiedades360.app.auth.dto.AuthResult;
import com.nc.Propiedades360.app.auth.dto.LoginRequest;
import com.nc.Propiedades360.app.auth.dto.RegisterRequest;
import com.nc.Propiedades360.app.auth.jwt.JwtService;
import com.nc.Propiedades360.app.auth.service.AuthService;
import com.nc.Propiedades360.app.usuario.dto.UsuarioDto;
import com.nc.Propiedades360.app.usuario.service.UsuarioService;
import jakarta.servlet.http.Cookie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthController.class)
@AutoConfigureMockMvc(addFilters = false)
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AuthService authService;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private UsuarioService usuarioService;


    @Test
    void login_DeberiaRetornar200YCookie() throws Exception {

        LoginRequest request = new LoginRequest();
        request.setUsername("emi");
        request.setContrasena("1234");

        AuthResponse authResponse = AuthResponse.builder()
                .id(1L)
                .role("CLIENTE")
                .build();

        AuthResult authResult =
                new AuthResult("jwt-token", authResponse);

        when(authService.iniciarSesion(any(LoginRequest.class)))
                .thenReturn(authResult);

        mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.role").value("CLIENTE"))
                .andExpect(header().exists(HttpHeaders.SET_COOKIE));
    }

    @Test
    void logout_DeberiaRetornar204() throws Exception {

        mockMvc.perform(post("/auth/logout"))
                .andExpect(status().isNoContent())
                .andExpect(header().exists(HttpHeaders.SET_COOKIE));
    }

    @Test
    void me_DeberiaRetornar401CuandoNoHayToken() throws Exception {

        mockMvc.perform(get("/auth/me"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void me_DeberiaRetornar401CuandoTokenExpirado() throws Exception {

        when(jwtService.isTokenExpired("token"))
                .thenReturn(true);

        mockMvc.perform(get("/auth/me")
                        .cookie(new Cookie("token", "token")))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void me_DeberiaRetornarUsuario() throws Exception {

        UsuarioDto usuario = new UsuarioDto();
        usuario.setUsername("emi");

        when(jwtService.isTokenExpired("token"))
                .thenReturn(false);

        when(jwtService.getUsernameFromToken("token"))
                .thenReturn("emi");

        when(usuarioService.findByUsername("emi"))
                .thenReturn(Optional.of(usuario));

        mockMvc.perform(get("/auth/me")
                        .cookie(new Cookie("token", "token")))
                .andExpect(status().isOk());
    }

    @Test
    void registrarCliente_DeberiaRetornar200() throws Exception {

        RegisterRequest request = new RegisterRequest();

        AuthResponse response = AuthResponse.builder()
                .id(1L)
                .role("CLIENTE")
                .build();

        when(authService.registrarCliente(any(RegisterRequest.class)))
                .thenReturn(response);

        mockMvc.perform(post("/auth/register/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.role").value("CLIENTE"));
    }
    @Test
    void registrarPropietario_DeberiaRetornar200() throws Exception {

        RegisterRequest request = new RegisterRequest();

        AuthResponse response = AuthResponse.builder()
                .role("PROPIETARIO")
                .build();

        when(authService.registrarPropietario(any(RegisterRequest.class)))
                .thenReturn(response);

        mockMvc.perform(post("/auth/register/propietario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.role").value("PROPIETARIO"));
    }
}