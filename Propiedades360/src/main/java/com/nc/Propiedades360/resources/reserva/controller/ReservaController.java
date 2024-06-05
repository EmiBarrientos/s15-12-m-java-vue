package com.nc.Propiedades360.resources.reserva.controller;


import com.nc.Propiedades360.resources.reserva.entity.Reserva;
import com.nc.Propiedades360.resources.reserva.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Reserva> detalleReserva(@PathVariable Long id) {
        Optional<Reserva> reserva = reservaService.findById(id);
        if (reserva.isPresent()) {
            return new ResponseEntity<>(reserva.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/confirmar")
    public ResponseEntity<Void> confirmarReserva(@PathVariable Long id) {
        if (reservaService.confirmarReserva(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelarReserva(@PathVariable Long id) {
        if (reservaService.cancelarReserva(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
