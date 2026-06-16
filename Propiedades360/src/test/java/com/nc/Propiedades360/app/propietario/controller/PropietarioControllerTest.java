package com.nc.Propiedades360.app.propietario.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nc.Propiedades360.app.auth.jwt.JwtAuthenticationFilter;
import com.nc.Propiedades360.app.auth.jwt.JwtService;
import com.nc.Propiedades360.app.exception.GlobalExceptionHandler;
import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
import com.nc.Propiedades360.app.inmueble.enums.EstadoInmueble;
import com.nc.Propiedades360.app.propietario.entity.Propietario;
import com.nc.Propiedades360.app.propietario.service.PropietarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest({PropietarioController.class})
@Import(GlobalExceptionHandler.class)
@AutoConfigureMockMvc(addFilters = false)
public class PropietarioControllerTest {

    @MockBean
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @MockBean
    private AuthenticationProvider authenticationProvider;

    @MockBean
    private JwtService jwtService;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
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




    // --- obtener ---

    @Test
    void obtener_idExiste_retorna200() throws Exception {
        when(propietarioService.getPropietarioById(1L)).thenReturn(propietario);

        mockMvc.perform(get("/api/propietarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("maria.garcia@email.com"));
    }

    @Test
    void obtener_idNoExiste_retorna404() throws Exception {
        when(propietarioService.getPropietarioById(99L))
                .thenThrow(new ResourceNotFoundException("Propietario no encontrado"));

        mockMvc.perform(get("/api/propietarios/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Propietario no encontrado"));
    }

    // --- obtenerInmuebles ---

    @Test
    void obtenerInmuebles_propietarioExiste_retorna200() throws Exception {
        when(propietarioService.getInmueblesByPropietario(1L)).thenReturn(List.of(inmueble));

        mockMvc.perform(get("/api/propietarios/1/inmuebles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Casa en Palermo"));
    }

    @Test
    void obtenerInmuebles_propietarioNoExiste_retorna404() throws Exception {
        when(propietarioService.getInmueblesByPropietario(99L))
                .thenThrow(new ResourceNotFoundException("Propietario no encontrado"));

        mockMvc.perform(get("/api/propietarios/99/inmuebles"))
                .andExpect(status().isNotFound());
    }

    // --- publicarInmueble ---

    @Test
    void publicarInmueble_propietarioExiste_retorna200() throws Exception {
        when(propietarioService.publicarInmueble(any(Inmueble.class), eq(1L))).thenReturn(inmueble);

        mockMvc.perform(post("/api/propietarios/1/inmuebles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inmueble)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Casa en Palermo"));
    }

    @Test
    void publicarInmueble_propietarioNoExiste_retorna404() throws Exception {
        when(propietarioService.publicarInmueble(any(Inmueble.class), eq(99L)))
                .thenThrow(new ResourceNotFoundException("Propietario no encontrado"));

        mockMvc.perform(post("/api/propietarios/99/inmuebles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inmueble)))
                .andExpect(status().isNotFound());
    }

    // --- actualizarInmueble ---

    @Test
    void actualizarInmueble_inmuebleExiste_retorna200() throws Exception {
        when(propietarioService.actualizarInmueble(eq(1L), any(Inmueble.class))).thenReturn(inmueble);

        mockMvc.perform(put("/api/propietarios/inmuebles/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inmueble)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Casa en Palermo"));
    }

    @Test
    void actualizarInmueble_inmuebleNoExiste_retorna404() throws Exception {
        when(propietarioService.actualizarInmueble(eq(99L), any(Inmueble.class)))
                .thenThrow(new ResourceNotFoundException("Inmueble no encontrado"));

        mockMvc.perform(put("/api/propietarios/inmuebles/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inmueble)))
                .andExpect(status().isNotFound());
    }

    // --- eliminarInmueble ---

    @Test
    void eliminarInmueble_inmuebleExiste_retorna204() throws Exception {
        mockMvc.perform(delete("/api/propietarios/inmuebles/1"))
                .andExpect(status().isNoContent());

        verify(propietarioService, times(1)).eliminarInmueble(1L);
    }

    @Test
    void eliminarInmueble_inmuebleNoExiste_retorna404() throws Exception {
        doThrow(new ResourceNotFoundException("Inmueble no encontrado"))
                .when(propietarioService).eliminarInmueble(99L);

        mockMvc.perform(delete("/api/propietarios/inmuebles/99"))
                .andExpect(status().isNotFound());
    }
}