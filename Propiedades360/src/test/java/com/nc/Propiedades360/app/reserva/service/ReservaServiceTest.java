package com.nc.Propiedades360.app.reserva.service;

import com.nc.Propiedades360.app.cliente.entity.Cliente;
import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
import com.nc.Propiedades360.app.inmueble.enums.EstadoInmueble;
import com.nc.Propiedades360.app.inmueble.service.InmuebleService;
import com.nc.Propiedades360.app.reserva.entity.Reserva;
import com.nc.Propiedades360.app.reserva.enums.Estado;
import com.nc.Propiedades360.app.reserva.repository.ReservaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReservaServiceTest {

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private InmuebleService inmuebleService;

    @InjectMocks
    private ReservaService reservaService;

    private Cliente cliente;
    private Inmueble inmueble;
    private Reserva reserva;

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
        reserva.setFechaInicio(LocalDate.now());
        reserva.setFechaFin(LocalDate.now().plusDays(7));
        reserva.setEstado(Estado.PENDIENTE);
    }

    // --- findById ---

    @Test
    void findById_idExiste_retornaReserva() {
        when(reservaRepository.findById(1L)).thenReturn(Optional.of(reserva));

        Optional<Reserva> resultado = reservaService.findById(1L);

        assertTrue(resultado.isPresent());
        assertEquals(1L, resultado.get().getId());
    }

    @Test
    void findById_idNoExiste_retornaVacio() {
        when(reservaRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Reserva> resultado = reservaService.findById(99L);

        assertTrue(resultado.isEmpty());
    }

    // --- crearReserva ---

    @Test
    void crearReserva_datosValidos_creaReservaEnPendiente() {
        when(reservaRepository.save(any(Reserva.class))).thenReturn(reserva);

        Reserva resultado = reservaService.crearReserva(
                cliente, inmueble, LocalDate.now(), LocalDate.now().plusDays(7)
        );

        assertNotNull(resultado);
        assertEquals(Estado.PENDIENTE, resultado.getEstado());
        verify(reservaRepository, times(1)).save(any(Reserva.class));
    }

    // --- confirmarReserva ---

    @Test
    void confirmarReserva_reservaExiste_confirma() {
        when(reservaRepository.findById(1L)).thenReturn(Optional.of(reserva));
        when(reservaRepository.save(reserva)).thenReturn(reserva);

        Reserva resultado = reservaService.confirmarReserva(1L);

        assertEquals(Estado.CONFIRMADA, resultado.getEstado());
        verify(reservaRepository, times(1)).save(reserva);
    }

    @Test
    void confirmarReserva_reservaNoExiste_lanzaExcepcion() {
        when(reservaRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> reservaService.confirmarReserva(99L)
        );

        verify(reservaRepository, never()).save(any());
    }

    // --- cancelarReserva ---

    @Test
    void cancelarReserva_reservaExiste_cancelaYliberaInmueble() {
        when(reservaRepository.findById(1L)).thenReturn(Optional.of(reserva));
        when(reservaRepository.save(reserva)).thenReturn(reserva);

        Reserva resultado = reservaService.cancelarReserva(1L);

        assertEquals(Estado.CANCELADA, resultado.getEstado());
        verify(inmuebleService, times(1)).actualizarEstado(inmueble.getId(), EstadoInmueble.DISPONIBLE);
        verify(reservaRepository, times(1)).save(reserva);
    }

    @Test
    void cancelarReserva_reservaNoExiste_lanzaExcepcion() {
        when(reservaRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class,
                () -> reservaService.cancelarReserva(99L)
        );

        verify(reservaRepository, never()).save(any());
        verify(inmuebleService, never()).actualizarEstado(any(), any());
    }
}