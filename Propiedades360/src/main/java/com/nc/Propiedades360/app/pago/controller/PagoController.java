package com.nc.Propiedades360.app.pago.controller;


import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.pago.entity.Pago;
import com.nc.Propiedades360.app.pago.enums.EstadoPago;
import com.nc.Propiedades360.app.pago.service.PagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pagos")
public class PagoController {


    private PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pago> detalle(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado")));
    }


    @GetMapping("/{id}/estado")
    public ResponseEntity<EstadoPago> estado(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.verificarEstadoPago(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado")));
    }
}

