package com.nc.Propiedades360.resources.pago.controller;


import com.nc.Propiedades360.resources.pago.entity.Pago;
import com.nc.Propiedades360.resources.pago.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping("/{id}")
    public ResponseEntity<Pago> detallePago(@PathVariable Long id) {
        Optional<Pago> pago = pagoService.findById(id);
        return pago.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{id}/procesar")
    public ResponseEntity<Void> procesarPago(@PathVariable Long id) {
        if (pagoService.procesarPago(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/verificar")
    public ResponseEntity<Pago.EstadoPago> verificarEstadoPago(@PathVariable Long id) {
        Optional<Pago.EstadoPago> estadoPago = pagoService.verificarEstadoPago(id);
        return estadoPago.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
