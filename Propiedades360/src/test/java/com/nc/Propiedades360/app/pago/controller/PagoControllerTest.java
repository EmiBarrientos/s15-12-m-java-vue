package com.nc.Propiedades360.app.pago.controller;

import com.nc.Propiedades360.app.auth.jwt.JwtAuthenticationFilter;
import com.nc.Propiedades360.app.auth.jwt.JwtService;
import com.nc.Propiedades360.app.pago.entity.Pago;
import com.nc.Propiedades360.app.pago.enums.EstadoPago;
import com.nc.Propiedades360.app.pago.service.PagoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PagoController.class)
@AutoConfigureMockMvc(addFilters = false)
public class PagoControllerTest {

    @MockBean
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @MockBean
    private AuthenticationProvider authenticationProvider;

    @MockBean
    private JwtService jwtService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PagoService pagoService;

    private Pago pago;

    @BeforeEach
    void setUp() {
        pago = new Pago();
        pago.setId(1L);
        pago.setMonto(BigDecimal.valueOf(150000));
        pago.setMetodoPago("TRANSFERENCIA");
        pago.setEstadoPago(EstadoPago.COMPLETADO);
    }

    // --- detalle ---

    @Test
    void detalle_idExiste_retorna200() throws Exception {
        when(pagoService.findById(1L)).thenReturn(Optional.of(pago));

        mockMvc.perform(get("/api/pagos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.estadoPago").value("COMPLETADO"));
    }

    @Test
    void detalle_idNoExiste_retorna404() throws Exception {
        when(pagoService.findById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/pagos/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Pago no encontrado"));
    }

    // --- estado ---

    @Test
    void estado_idExiste_retorna200() throws Exception {
        when(pagoService.verificarEstadoPago(1L)).thenReturn(Optional.of(EstadoPago.COMPLETADO));

        mockMvc.perform(get("/api/pagos/1/estado"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("COMPLETADO"));
    }

    @Test
    void estado_idNoExiste_retorna404() throws Exception {
        when(pagoService.verificarEstadoPago(99L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/pagos/99/estado"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Pago no encontrado"));
    }
}