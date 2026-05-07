package com.nc.Propiedades360.resources.Cliente.Service;

import com.nc.Propiedades360.resources.Cliente.Entity.Cliente;
import com.nc.Propiedades360.resources.Cliente.Repository.ClienteRepository;
import com.nc.Propiedades360.resources.Usuario.enums.Rol;
import com.nc.Propiedades360.resources.inmueble.entity.Inmueble;
import com.nc.Propiedades360.resources.inmueble.repository.InmuebleRepository;
import com.nc.Propiedades360.resources.pago.entity.Pago;
import com.nc.Propiedades360.resources.pago.repository.PagoRepository;
import com.nc.Propiedades360.resources.reserva.entity.Reserva;
import com.nc.Propiedades360.resources.reserva.repository.ReservaRepository;
import com.nc.Propiedades360.resources.reserva.service.ReservaService;
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
    @Mock private InmuebleRepository inmuebleRepository;
    @Mock private ReservaRepository reservaRepository;
    @Mock private PagoRepository pagoRepository;
    @Mock private ReservaService reservaService;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente;
    private Inmueble inmueble;
    private Reserva reserva;

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
        inmueble.setPrecio(150000.0);

        reserva = new Reserva();
        reserva.setId(1L);
        reserva.setCliente(cliente);
        reserva.setInmueble(inmueble);
        reserva.setEstado(Reserva.Estado.PENDIENTE);
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

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> clienteService.getClienteById(99L)
        );

        assertEquals("Cliente no encontrado", ex.getMessage());
    }

    // --- buscarInmueble ---

    @Test
    void buscarInmueble_inmuebleExiste_retornaInmueble() {
        when(inmuebleRepository.findById(1L)).thenReturn(Optional.of(inmueble));

        Inmueble resultado = clienteService.buscarInmueble(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
    }

    @Test
    void buscarInmueble_inmuebleNoExiste_lanzaExcepcion() {
        when(inmuebleRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> clienteService.buscarInmueble(99L)
        );

        assertEquals("Inmueble no encontrado", ex.getMessage());
    }

    // --- reservarInmueble ---

    @Test
    void reservarInmueble_disponible_creaReservaConfirmada() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(inmuebleRepository.findById(1L)).thenReturn(Optional.of(inmueble));
        when(reservaService.confirmarReserva(1L)).thenReturn(false); // disponible

        clienteService.reservarInmueble(cliente, inmueble,
                LocalDate.now(), LocalDate.now().plusDays(7));

        verify(reservaRepository, times(1)).save(any(Reserva.class));
        verify(inmuebleRepository, times(1)).save(inmueble);
    }

    @Test
    void reservarInmueble_noDisponible_lanzaExcepcion() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(inmuebleRepository.findById(1L)).thenReturn(Optional.of(inmueble));
        when(reservaService.confirmarReserva(1L)).thenReturn(true); // no disponible

        assertThrows(IllegalStateException.class,
                () -> clienteService.reservarInmueble(cliente, inmueble,
                        LocalDate.now(), LocalDate.now().plusDays(7))
        );

        verify(reservaRepository, never()).save(any());
    }

    @Test
    void reservarInmueble_clienteNoExiste_lanzaExcepcion() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class,
                () -> clienteService.reservarInmueble(cliente, inmueble,
                        LocalDate.now(), LocalDate.now().plusDays(7))
        );

        verify(reservaRepository, never()).save(any());
    }

    // --- realizarPago ---

    @Test
    void realizarPago_reservaPendiente_procesaPagoYconfirmaReserva() {
        Pago pago = mock(Pago.class);
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(reservaRepository.findById(1L)).thenReturn(Optional.of(reserva));
        when(pagoRepository.save(any(Pago.class))).thenReturn(pago);
        when(pago.verificarEstadoPago()).thenReturn(Pago.EstadoPago.COMPLETADO);

        clienteService.realizarPago(1L, 1L, BigDecimal.valueOf(150000), "TRANSFERENCIA");

        verify(pagoRepository, times(1)).save(any(Pago.class));
        verify(reservaRepository, times(1)).save(reserva);
    }

    @Test
    void realizarPago_reservaNoEstaEnPendiente_lanzaExcepcion() {
        reserva.setEstado(Reserva.Estado.CONFIRMADA);
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(reservaRepository.findById(1L)).thenReturn(Optional.of(reserva));

        assertThrows(IllegalStateException.class,
                () -> clienteService.realizarPago(1L, 1L, BigDecimal.valueOf(150000), "TRANSFERENCIA")
        );

        verify(pagoRepository, never()).save(any());
    }

    @Test
    void realizarPago_clienteNoExiste_lanzaExcepcion() {
        when(clienteRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class,
                () -> clienteService.realizarPago(99L, 1L, BigDecimal.valueOf(150000), "TRANSFERENCIA")
        );

        verify(pagoRepository, never()).save(any());
    }

    @Test
    void realizarPago_reservaNoExiste_lanzaExcepcion() {
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        when(reservaRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class,
                () -> clienteService.realizarPago(1L, 99L, BigDecimal.valueOf(150000), "TRANSFERENCIA")
        );

        verify(pagoRepository, never()).save(any());
    }
}