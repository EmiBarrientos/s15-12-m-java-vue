package com.nc.Propiedades360.app.visita.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nc.Propiedades360.app.auth.jwt.JwtAuthenticationFilter;
import com.nc.Propiedades360.app.auth.jwt.JwtService;
import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.visita.entity.Visita;
import com.nc.Propiedades360.app.visita.service.VisitaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VisitaController.class)
@AutoConfigureMockMvc(addFilters = false)
public class VisitaControllerTest {

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
    private VisitaService visitaService;

    private Visita visita;

    @BeforeEach
    void setUp() {
        visita = new Visita();
        visita.setId(1L);
        visita.setFechaVisita(LocalDate.now());
    }

    // --- obtenerTodas ---

    @Test
    void obtenerTodas_retorna200() throws Exception {
        when(visitaService.findAll()).thenReturn(List.of(visita));

        mockMvc.perform(get("/api/visitas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L));
    }

    // --- obtener ---

    @Test
    void obtener_idExiste_retorna200() throws Exception {
        when(visitaService.findById(1L)).thenReturn(visita);

        mockMvc.perform(get("/api/visitas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    void obtener_idNoExiste_retorna404() throws Exception {
        when(visitaService.findById(99L))
                .thenThrow(new ResourceNotFoundException("Visita no encontrada"));

        mockMvc.perform(get("/api/visitas/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Visita no encontrada"));
    }

    // --- crear ---

    @Test
    void crear_datosValidos_retorna200() throws Exception {
        when(visitaService.crearVisita(any(Visita.class))).thenReturn(visita);

        mockMvc.perform(post("/api/visitas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(visita)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }

    // --- actualizar ---

    @Test
    void actualizar_visitaExiste_retorna200() throws Exception {
        when(visitaService.actualizarVisita(any(Visita.class))).thenReturn(visita);

        mockMvc.perform(put("/api/visitas/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(visita)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    void actualizar_visitaNoExiste_retorna404() throws Exception {
        when(visitaService.actualizarVisita(any(Visita.class)))
                .thenThrow(new ResourceNotFoundException("Visita no encontrada"));

        mockMvc.perform(put("/api/visitas/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(visita)))
                .andExpect(status().isNotFound());
    }

    // --- eliminar ---

    @Test
    void eliminar_visitaExiste_retorna204() throws Exception {
        mockMvc.perform(delete("/api/visitas/1"))
                .andExpect(status().isNoContent());

        verify(visitaService, times(1)).eliminarVisita(1L);
    }

    @Test
    void eliminar_visitaNoExiste_retorna404() throws Exception {
        doThrow(new ResourceNotFoundException("Visita no encontrada"))
                .when(visitaService).eliminarVisita(99L);

        mockMvc.perform(delete("/api/visitas/99"))
                .andExpect(status().isNotFound());
    }
}