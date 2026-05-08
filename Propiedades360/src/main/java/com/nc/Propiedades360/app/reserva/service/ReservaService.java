package com.nc.Propiedades360.app.reserva.service;


import com.nc.Propiedades360.app.cliente.entity.Cliente;
import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
import com.nc.Propiedades360.app.inmueble.enums.EstadoInmueble;
import com.nc.Propiedades360.app.inmueble.service.InmuebleService;
import com.nc.Propiedades360.app.reserva.entity.Reserva;
import com.nc.Propiedades360.app.reserva.enums.Estado;
import com.nc.Propiedades360.app.reserva.repository.ReservaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final InmuebleService inmuebleService;


    public ReservaService(ReservaRepository reservaRepository, InmuebleService inmuebleService) {
        this.reservaRepository = reservaRepository;
        this.inmuebleService = inmuebleService;
    }

    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id);
    }

    @Transactional
    public Reserva crearReserva(Cliente cliente, Inmueble inmueble, LocalDate fechaInicio, LocalDate fechaFin) {
        Reserva reserva = new Reserva();
        reserva.setCliente(cliente);
        reserva.setInmueble(inmueble);
        reserva.setFechaInicio(fechaInicio);
        reserva.setFechaFin(fechaFin);
        reserva.setEstado(Estado.PENDIENTE);

        inmuebleService.actualizarEstado(inmueble.getId(), EstadoInmueble.RESERVADO);

        return reservaRepository.save(reserva);
    }

    @Transactional
    public Reserva confirmarReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        reserva.setEstado(Estado.CONFIRMADA);
        return reservaRepository.save(reserva);
    }



    @Transactional
    public Reserva cancelarReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));

        reserva.setEstado(Estado.CANCELADA);
        inmuebleService.actualizarEstado(reserva.getInmueble().getId(), EstadoInmueble.DISPONIBLE);

        return reservaRepository.save(reserva);
    }
}
