package com.nc.Propiedades360.app.reserva.controller;


import com.nc.Propiedades360.app.reserva.entity.Reserva;
import com.nc.Propiedades360.app.reserva.service.ReservaService;
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
        if (reservaService.confirmarReserva(id)!=null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelarReserva(@PathVariable Long id) {
        if (reservaService.cancelarReserva(id)!=null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
