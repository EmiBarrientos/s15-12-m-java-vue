package com.nc.Propiedades360.app.pago.service;

import com.nc.Propiedades360.app.cliente.entity.Cliente;
import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
import com.nc.Propiedades360.app.inmueble.enums.EstadoInmueble;
import com.nc.Propiedades360.app.inmueble.service.InmuebleService;
import com.nc.Propiedades360.app.pago.entity.Pago;
import com.nc.Propiedades360.app.pago.enums.EstadoPago;
import com.nc.Propiedades360.app.pago.repository.PagoRepository;
import com.nc.Propiedades360.app.reserva.entity.Reserva;
import com.nc.Propiedades360.app.reserva.enums.Estado;
import com.nc.Propiedades360.app.reserva.service.ReservaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PagoServiceTest {

    @Mock
    private PagoRepository pagoRepository;

    @Mock
    private ReservaService reservaService;

    @Mock
    private InmuebleService inmuebleService;

    @InjectMocks
    private PagoService pagoService;

    private Cliente cliente;
    private Inmueble inmueble;
    private Reserva reserva;
    private Pago pago;

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Juan Pérez");

        inmueble = new Inmueble();
        inmueble.setId(1L);
        inmueble.setTitulo("Casa en Palermo");
        inmueble.setEstado(EstadoInmueble.DISPONIBLE);

        reserva = new Reserva();
        reserva.setId(1L);
        reserva.setCliente(cliente);
        reserva.setInmueble(inmueble);
        reserva.setEstado(Estado.PENDIENTE);

        pago = new Pago();
        pago.setId(1L);
        pago.setCliente(cliente);
        pago.setReserva(reserva);
        pago.setMonto(BigDecimal.valueOf(150000));
        pago.setMetodoPago("TRANSFERENCIA");
        pago.setEstadoPago(EstadoPago.PENDIENTE);
    }

    // --- findById ---

    @Test
    void findById_idExiste_retornaPago() {
        when(pagoRepository.findById(1L)).thenReturn(Optional.of(pago));

        Optional<Pago> resultado = pagoService.findById(1L);

        assertTrue(resultado.isPresent());
        assertEquals(1L, resultado.get().getId());
    }

    @Test
    void findById_idNoExiste_retornaVacio() {
        when(pagoRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Pago> resultado = pagoService.findById(99L);

        assertTrue(resultado.isEmpty());
    }

    // --- verificarEstadoPago ---

    @Test
    void verificarEstadoPago_idExiste_retornaEstado() {
        when(pagoRepository.findById(1L)).thenReturn(Optional.of(pago));

        Optional<EstadoPago> resultado = pagoService.verificarEstadoPago(1L);

        assertTrue(resultado.isPresent());
        assertEquals(EstadoPago.PENDIENTE, resultado.get());
    }

    @Test
    void verificarEstadoPago_idNoExiste_retornaVacio() {
        when(pagoRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<EstadoPago> resultado = pagoService.verificarEstadoPago(99L);

        assertTrue(resultado.isEmpty());
    }

    // --- procesarPago ---

    @Test
    void procesarPago_exitoso_guardaPagoYconfirmaReservaYactualizaInmueble() {
        when(pagoRepository.save(any(Pago.class))).thenReturn(pago);

        Pago resultado = pagoService.procesarPago(
                cliente, reserva, BigDecimal.valueOf(150000), "TRANSFERENCIA"
        );

        assertNotNull(resultado);
        assertEquals(EstadoPago.COMPLETADO, resultado.getEstadoPago());
        verify(pagoRepository, times(2)).save(any(Pago.class));
        verify(reservaService, times(1)).confirmarReserva(reserva.getId());
        verify(inmuebleService, times(1)).actualizarEstado(inmueble.getId(), EstadoInmueble.RESERVADO);
    }
}