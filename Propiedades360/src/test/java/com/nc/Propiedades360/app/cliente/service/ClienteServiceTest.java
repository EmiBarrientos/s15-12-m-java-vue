package com.nc.Propiedades360.app.cliente.service;

import com.nc.Propiedades360.app.cliente.entity.Cliente;
import com.nc.Propiedades360.app.cliente.repository.ClienteRepository;
import com.nc.Propiedades360.app.exception.InvalidStateException;
import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.exception.ResourceNotAvailableException;
import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
import com.nc.Propiedades360.app.inmueble.enums.EstadoInmueble;
import com.nc.Propiedades360.app.inmueble.service.InmuebleService;
import com.nc.Propiedades360.app.pago.entity.Pago;
import com.nc.Propiedades360.app.pago.enums.EstadoPago;
import com.nc.Propiedades360.app.pago.service.PagoService;
import com.nc.Propiedades360.app.reserva.entity.Reserva;
import com.nc.Propiedades360.app.reserva.enums.Estado;
import com.nc.Propiedades360.app.reserva.service.ReservaService;
import com.nc.Propiedades360.app.usuario.enums.Rol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock private ClienteRepository clienteRepository;
    @Mock private InmuebleService inmuebleService;
    @Mock private ReservaService reservaService;
    @Mock private PagoService pagoService;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente;
    private Inmueble inmueble;
    private Reserva reserva;
    private Pago pago;

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Juan Pérez");
        cliente.setEmail("juan.perez@email.com");
        cliente.setContrasena("Password123!");
        cliente.setTelefono("1134567890");

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
        pago.setEstadoPago(EstadoPago.COMPLETADO);
    }

    // --- saveCliente ---

    @Test
    void saveCliente_datosValidos_asignaRolYGuarda() {
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente resultado = clienteService.saveCliente(cliente);

        assertNotNull(resultado);
        assertEquals(Rol.CLIENTE, resultado.getRol());
        verify(clienteRepository, times(1)).save(cliente);
    }

    // --- getClienteById ---

    @Test
    void getClienteById_idExiste_retornaCliente() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Cliente resultado = clienteService.getClienteById(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
    }

    @Test
    void getClienteById_idNoExiste_lanzaExcepcion() {
        when(clienteRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> clienteService.getClienteById(99L)
        );
    }

    // --- reservarInmueble ---

    @Test
    void reservarInmueble_disponible_creaReserva() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(inmuebleService.verificarDisponibilidad(1L)).thenReturn(inmueble);
        when(reservaService.crearReserva(cliente, inmueble,
                LocalDate.now(), LocalDate.now().plusDays(7))).thenReturn(reserva);

        Reserva resultado = clienteService.reservarInmueble(
                1L, 1L, LocalDate.now(), LocalDate.now().plusDays(7)
        );

        assertNotNull(resultado);
        assertEquals(Estado.PENDIENTE, resultado.getEstado());
        verify(reservaService, times(1)).crearReserva(any(), any(), any(), any());
    }

    @Test
    void reservarInmueble_inmuebleNoDisponible_lanzaExcepcion() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(inmuebleService.verificarDisponibilidad(1L))
                .thenThrow(new ResourceNotAvailableException("El inmueble no está disponible"));

        assertThrows(ResourceNotAvailableException.class,
                () -> clienteService.reservarInmueble(1L, 1L,
                        LocalDate.now(), LocalDate.now().plusDays(7))
        );

        verify(reservaService, never()).crearReserva(any(), any(), any(), any());
    }

    @Test
    void reservarInmueble_clienteNoExiste_lanzaExcepcion() {
        when(clienteRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> clienteService.reservarInmueble(99L, 1L,
                        LocalDate.now(), LocalDate.now().plusDays(7))
        );

        verify(reservaService, never()).crearReserva(any(), any(), any(), any());
    }

    // --- realizarPago ---

    @Test
    void realizarPago_reservaPendiente_procesaPago() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(reservaService.findById(1L)).thenReturn(Optional.of(reserva));
        when(pagoService.procesarPago(cliente, reserva,
                BigDecimal.valueOf(150000), "TRANSFERENCIA")).thenReturn(pago);

        Pago resultado = clienteService.realizarPago(
                1L, 1L, BigDecimal.valueOf(150000), "TRANSFERENCIA"
        );

        assertNotNull(resultado);
        assertEquals(EstadoPago.COMPLETADO, resultado.getEstadoPago());
        verify(pagoService, times(1)).procesarPago(any(), any(), any(), any());
    }

    @Test
    void realizarPago_reservaNoEstaEnPendiente_lanzaExcepcion() {
        reserva.setEstado(Estado.CONFIRMADA);
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(reservaService.findById(1L)).thenReturn(Optional.of(reserva));

        assertThrows(InvalidStateException.class,
                () -> clienteService.realizarPago(1L, 1L,
                        BigDecimal.valueOf(150000), "TRANSFERENCIA")
        );

        verify(pagoService, never()).procesarPago(any(), any(), any(), any());
    }

    @Test
    void realizarPago_clienteNoExiste_lanzaExcepcion() {
        when(clienteRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> clienteService.realizarPago(99L, 1L,
                        BigDecimal.valueOf(150000), "TRANSFERENCIA")
        );

        verify(pagoService, never()).procesarPago(any(), any(), any(), any());
    }

    @Test
    void realizarPago_reservaNoExiste_lanzaExcepcion() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(reservaService.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> clienteService.realizarPago(1L, 99L,
                        BigDecimal.valueOf(150000), "TRANSFERENCIA")
        );

        verify(pagoService, never()).procesarPago(any(), any(), any(), any());
    }
}