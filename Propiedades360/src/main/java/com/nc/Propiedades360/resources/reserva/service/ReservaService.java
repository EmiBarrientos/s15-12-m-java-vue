package com.nc.Propiedades360.resources.reserva.service;


import com.nc.Propiedades360.resources.reserva.entity.Reserva;
import com.nc.Propiedades360.resources.reserva.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id);
    }

    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public boolean confirmarReserva(Long id) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(id);
        if (reservaOptional.isPresent()) {
            Reserva reserva = reservaOptional.get();
            reserva.confirmarReserva();
            reservaRepository.save(reserva);
            return true;
        }
        return false;
    }

    public boolean cancelarReserva(Long id) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(id);
        if (reservaOptional.isPresent()) {
            Reserva reserva = reservaOptional.get();
            reserva.cancelarReserva();
            reservaRepository.save(reserva);
            return true;
        }
        return false;
    }
}
