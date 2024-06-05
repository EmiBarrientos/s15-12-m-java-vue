package com.nc.Propiedades360.resources.visita.controller;

import com.nc.Propiedades360.resources.visita.entity.Visita;
import com.nc.Propiedades360.resources.visita.service.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/visitas")
public class VisitaController {

    @Autowired
    private VisitaService visitaService;

    @GetMapping("/{id}")
    public ResponseEntity<Visita> detalleVisita(@PathVariable Long id) {
        Optional<Visita> visita = visitaService.findById(id);
        return visita.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{id}/confirmar")
    public ResponseEntity<Void> confirmarVisita(@PathVariable Long id) {
        if (visitaService.confirmarVisita(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelarVisita(@PathVariable Long id) {
        if (visitaService.cancelarVisita(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
