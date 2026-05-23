package com.nc.Propiedades360.app.reserva.controller;


import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.reserva.entity.Reserva;
import com.nc.Propiedades360.app.reserva.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }



    @GetMapping("/{id}")
    public ResponseEntity<Reserva> detalle(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada")));
    }

    @PostMapping("/{id}/confirmar")
    public ResponseEntity<Reserva> confirmar(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.confirmarReserva(id));
    }


    @PostMapping("/{id}/cancelar")
    public ResponseEntity<Reserva> cancelar(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.cancelarReserva(id));
    }
}
