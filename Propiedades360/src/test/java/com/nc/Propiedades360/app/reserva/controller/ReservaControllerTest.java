package com.nc.Propiedades360.app.reserva.controller;

import com.nc.Propiedades360.app.auth.jwt.JwtAuthenticationFilter;
import com.nc.Propiedades360.app.auth.jwt.JwtService;
import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.reserva.entity.Reserva;
import com.nc.Propiedades360.app.reserva.enums.Estado;
import com.nc.Propiedades360.app.reserva.service.ReservaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReservaController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ReservaControllerTest {

    @MockBean
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @MockBean
    private AuthenticationProvider authenticationProvider;

    @MockBean
    private JwtService jwtService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservaService reservaService;

    private Reserva reserva;

    @BeforeEach
    void setUp() {
        reserva = new Reserva();
        reserva.setId(1L);
        reserva.setEstado(Estado.PENDIENTE);
    }

    // --- detalle ---

    @Test
    void detalle_idExiste_retorna200() throws Exception {
        when(reservaService.findById(1L)).thenReturn(Optional.of(reserva));

        mockMvc.perform(get("/api/reservas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.estado").value("PENDIENTE"));
    }

    @Test
    void detalle_idNoExiste_retorna404() throws Exception {
        when(reservaService.findById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/reservas/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Reserva no encontrada"));
    }

    // --- confirmar ---

    @Test
    void confirmar_reservaExiste_retorna200() throws Exception {
        reserva.setEstado(Estado.CONFIRMADA);
        when(reservaService.confirmarReserva(1L)).thenReturn(reserva);

        mockMvc.perform(post("/api/reservas/1/confirmar"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.estado").value("CONFIRMADA"));
    }

    @Test
    void confirmar_reservaNoExiste_retorna404() throws Exception {
        when(reservaService.confirmarReserva(99L))
                .thenThrow(new ResourceNotFoundException("Reserva no encontrada"));

        mockMvc.perform(post("/api/reservas/99/confirmar"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Reserva no encontrada"));
    }

    // --- cancelar ---

    @Test
    void cancelar_reservaExiste_retorna200() throws Exception {
        reserva.setEstado(Estado.CANCELADA);
        when(reservaService.cancelarReserva(1L)).thenReturn(reserva);

        mockMvc.perform(post("/api/reservas/1/cancelar"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.estado").value("CANCELADA"));
    }

    @Test
    void cancelar_reservaNoExiste_retorna404() throws Exception {
        when(reservaService.cancelarReserva(99L))
                .thenThrow(new ResourceNotFoundException("Reserva no encontrada"));

        mockMvc.perform(post("/api/reservas/99/cancelar"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Reserva no encontrada"));
    }
}