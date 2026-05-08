package com.nc.Propiedades360.app.cliente.service;

import com.nc.Propiedades360.app.cliente.entity.Cliente;
import com.nc.Propiedades360.app.cliente.repository.ClienteRepository;
import com.nc.Propiedades360.app.usuario.enums.Rol;
import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
import com.nc.Propiedades360.app.inmueble.service.InmuebleService;
import com.nc.Propiedades360.app.pago.entity.Pago;
import com.nc.Propiedades360.app.pago.service.PagoService;
import com.nc.Propiedades360.app.reserva.entity.Reserva;
import com.nc.Propiedades360.app.reserva.service.ReservaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final InmuebleService inmuebleService;
    private final ReservaService reservaService;
    private final PagoService pagoService;

    public ClienteService(ClienteRepository clienteRepository, InmuebleService inmuebleService, ReservaService reservaService, PagoService pagoService) {
        this.clienteRepository = clienteRepository;
        this.inmuebleService = inmuebleService;
        this.reservaService = reservaService;
        this.pagoService = pagoService;
    }

    public Cliente saveCliente(Cliente cliente) {
        cliente.setRol(Rol.CLIENTE);
        return clienteRepository.save(cliente);
    }

    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }



    @Transactional
    public Reserva reservarInmueble(Long clienteId, Long inmuebleId, LocalDate fechaInicio, LocalDate fechaFin) {
        Cliente cliente = getClienteById(clienteId);

        // verifica disponibilidad y lanza excepción si no está disponible
        Inmueble inmueble = inmuebleService.verificarDisponibilidad(inmuebleId);

        return reservaService.crearReserva(cliente, inmueble, fechaInicio, fechaFin);
    }



    @Transactional
    public Pago realizarPago(Long clienteId, Long reservaId, BigDecimal monto, String metodoPago) {
        Cliente cliente = getClienteById(clienteId);

        Reserva reserva = reservaService.findById(reservaId)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        if (reserva.getEstado() != com.nc.Propiedades360.app.reserva.enums.Estado.PENDIENTE) {
            throw new IllegalStateException("La reserva no está en estado PENDIENTE");
        }

        return pagoService.procesarPago(cliente, reserva, monto, metodoPago);
    }
}
