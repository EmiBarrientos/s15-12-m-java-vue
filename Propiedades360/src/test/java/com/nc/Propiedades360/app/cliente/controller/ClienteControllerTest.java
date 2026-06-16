package com.nc.Propiedades360.app.cliente.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nc.Propiedades360.app.auth.jwt.JwtAuthenticationFilter;
import com.nc.Propiedades360.app.auth.jwt.JwtService;
import com.nc.Propiedades360.app.cliente.entity.Cliente;
import com.nc.Propiedades360.app.cliente.http.request.PagoRequest;
import com.nc.Propiedades360.app.cliente.http.request.ReservaRequest;
import com.nc.Propiedades360.app.cliente.service.ClienteService;
import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.exception.ResourceNotAvailableException;
import com.nc.Propiedades360.app.pago.entity.Pago;
import com.nc.Propiedades360.app.pago.enums.EstadoPago;
import com.nc.Propiedades360.app.reserva.entity.Reserva;
import com.nc.Propiedades360.app.reserva.enums.Estado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

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
    private ClienteService clienteService;

    private Cliente cliente;
    private Reserva reserva;
    private Pago pago;
    private ReservaRequest reservaRequest;
    private PagoRequest pagoRequest;

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Juan Pérez");
        cliente.setEmail("juan.perez@email.com");
        cliente.setContrasena("Password123!");
        cliente.setTelefono("1134567890");

        reserva = new Reserva();
        reserva.setId(1L);
        reserva.setEstado(Estado.PENDIENTE);

        pago = new Pago();
        pago.setId(1L);
        pago.setMonto(BigDecimal.valueOf(150000));
        pago.setMetodoPago("TRANSFERENCIA");
        pago.setEstadoPago(EstadoPago.COMPLETADO);

        reservaRequest = new ReservaRequest();
        reservaRequest.setClienteId(1L);
        reservaRequest.setInmuebleId(1L);
        reservaRequest.setFechaInicio(LocalDate.now());
        reservaRequest.setFechaFin(LocalDate.now().plusDays(7));

        pagoRequest = new PagoRequest();
        pagoRequest.setClienteId(1L);
        pagoRequest.setReservaId(1L);
        pagoRequest.setMonto(BigDecimal.valueOf(150000));
        pagoRequest.setMetodoPago("TRANSFERENCIA");
    }


    // --- obtener ---

    @Test
    void obtener_idExiste_retorna200() throws Exception {
        when(clienteService.getClienteById(1L)).thenReturn(cliente);

        mockMvc.perform(get("/api/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("juan.perez@email.com"))
                .andDo(print());

    }

    @Test
    void obtener_idNoExiste_retorna404() throws Exception {
        when(clienteService.getClienteById(99L))
                .thenThrow(new ResourceNotFoundException("Cliente no encontrado"));

        mockMvc.perform(get("/api/clientes/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Cliente no encontrado"));
    }

    // --- reservar ---

    @Test
    void reservar_inmuebleDisponible_retorna200() throws Exception {
        when(clienteService.reservarInmueble(1L, 1L,
                LocalDate.now(), LocalDate.now().plusDays(7))).thenReturn(reserva);

        mockMvc.perform(post("/api/clientes/reservar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reservaRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.estado").value("PENDIENTE"));
    }

    @Test
    void reservar_inmuebleNoDisponible_retorna409() throws Exception {
        when(clienteService.reservarInmueble(any(), any(), any(), any()))
                .thenThrow(new ResourceNotAvailableException("El inmueble no está disponible"));

        mockMvc.perform(post("/api/clientes/reservar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reservaRequest)))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.error").value("El inmueble no está disponible"));
    }

    @Test
    void reservar_clienteNoExiste_retorna404() throws Exception {
        when(clienteService.reservarInmueble(any(), any(), any(), any()))
                .thenThrow(new ResourceNotFoundException("Cliente no encontrado"));

        mockMvc.perform(post("/api/clientes/reservar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reservaRequest)))
                .andExpect(status().isNotFound());
    }

    // --- pagar ---

    @Test
    void pagar_reservaPendiente_retorna200() throws Exception {
        when(clienteService.realizarPago(1L, 1L,
                BigDecimal.valueOf(150000), "TRANSFERENCIA")).thenReturn(pago);

        mockMvc.perform(post("/api/clientes/pagar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pagoRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.estadoPago").value("COMPLETADO"));
    }

    @Test
    void pagar_reservaNoExiste_retorna404() throws Exception {
        when(clienteService.realizarPago(any(), any(), any(), any()))
                .thenThrow(new ResourceNotFoundException("Reserva no encontrada"));

        mockMvc.perform(post("/api/clientes/pagar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pagoRequest)))
                .andExpect(status().isNotFound());
    }
}