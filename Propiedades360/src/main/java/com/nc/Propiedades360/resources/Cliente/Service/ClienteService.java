package com.nc.Propiedades360.resources.Cliente.Service;

import com.nc.Propiedades360.resources.Cliente.Entity.Cliente;
import com.nc.Propiedades360.resources.Cliente.Repository.ClienteRepository;
import com.nc.Propiedades360.resources.Propietario.Entity.Propietario;
import com.nc.Propiedades360.resources.inmueble.entity.Inmueble;
import com.nc.Propiedades360.resources.inmueble.repository.InmuebleRepository;
import com.nc.Propiedades360.resources.pago.entity.Pago;
import com.nc.Propiedades360.resources.pago.repository.PagoRepository;
import com.nc.Propiedades360.resources.reserva.entity.Reserva;
import com.nc.Propiedades360.resources.reserva.repository.ReservaRepository;
import com.nc.Propiedades360.resources.reserva.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
@Service
public class ClienteService {

    private final InmuebleRepository inmuebleRepository;
    private final ClienteRepository clienteRepository;
    private final ReservaRepository reservaRepository;

    private final PagoRepository pagoRepository;

    // Inyección de dependencias a través del constructor
    public ClienteService( InmuebleRepository inmuebleRepository, ClienteRepository clienteRepository, ReservaRepository reservaRepository, PagoRepository pagoRepository) {

        this.inmuebleRepository = inmuebleRepository;
        this.clienteRepository = clienteRepository;
        this.reservaRepository = reservaRepository;
        this.pagoRepository = pagoRepository;
    }


    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Transactional
    public Inmueble buscarInmueble(Long inmuebleId) {
        Inmueble inmueble = inmuebleRepository.findById(inmuebleId).orElse(null);
        if (inmueble == null) {
            throw new RuntimeException("Inmueble no encontrado");
        }
        return inmueble;
    }

    @Transactional
    public void reservarInmueble(Cliente cliente, Inmueble inmueble, LocalDate fechaInicio, LocalDate fechaFin) {
        // Verificar si el cliente y el inmueble existen
        Cliente clienteExistente = clienteRepository.findById(cliente.getId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        Inmueble inmuebleExistente = inmuebleRepository.findById(inmueble.getId())
                .orElseThrow(() -> new IllegalArgumentException("Inmueble no encontrado"));

        // Verificar si el inmueble está disponible para la reserva
        ReservaService reservaService = new ReservaService(reservaRepository);
        if (reservaService.confirmarReserva(inmuebleExistente.getId())) {
            throw new IllegalStateException("El inmueble no está disponible para reserva");
        }

        // Crear una nueva reserva
        Reserva reserva = new Reserva();
        reserva.setFechaInicio(fechaInicio);
        reserva.setFechaFin(fechaFin);
        reserva.setCliente(clienteExistente);
        reserva.setInmueble(inmuebleExistente);
        reserva.setEstado(Reserva.Estado.PENDIENTE);

        // Guardar la reserva
        reservaRepository.save(reserva);

        // Actualizar el estado del inmueble a no disponible
        reserva.setEstado(Reserva.Estado.CONFIRMADA);
        inmuebleRepository.save(inmuebleExistente);
    }


    @Transactional
    public void realizarPago(Long clienteId, Long reservaId, BigDecimal monto, String metodoPago) {
        // Verificar si el cliente y la reserva existen
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new IllegalArgumentException("Reserva no encontrada"));

        // Verificar si la reserva está en estado PENDIENTE
        if (reserva.getEstado() != Reserva.Estado.PENDIENTE) {
            throw new IllegalStateException("La reserva no está en estado PENDIENTE");
        }

        // Crear un nuevo pago
        Pago pago = new Pago();
        pago.setMonto(monto);
        pago.setMetodoPago(metodoPago);
        pago.setClienteId(clienteId);
        pago.setReservaId(reservaId);
        pago.setEstadoPago(Pago.EstadoPago.PENDIENTE);

        // Guardar el pago
        pagoRepository.save(pago);

        // Procesar el pago
        pago.procesarPago();

        // Actualizar el estado de la reserva a CONFIRMADA
        if (pago.verificarEstadoPago() == Pago.EstadoPago.COMPLETADO) {
            reserva.confirmarReserva();
            reservaRepository.save(reserva);
        }
    }
}
