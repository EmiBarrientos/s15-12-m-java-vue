package com.nc.Propiedades360.resources.visita.controller;

import com.nc.Propiedades360.resources.visita.entity.Visita;
import com.nc.Propiedades360.resources.visita.service.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visitas")
public class VisitaController {

    private final VisitaService visitaService;

    @Autowired
    public VisitaController(VisitaService visitaService) {
        this.visitaService = visitaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Visita>> getAllVisits() {
        List<Visita> visitas = visitaService.findAll();
        return ResponseEntity.ok(visitas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visita> getVisitById(@PathVariable Long id) {
        Visita visita = visitaService.findById(id);
        return ResponseEntity.ok(visita);
    }

    @PostMapping("/create")
    public ResponseEntity<Visita> createVisit(@RequestBody Visita visita) {
        Visita newVisita = visitaService.crearVisita(visita);
        return ResponseEntity.ok(newVisita);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Visita> updateVisit(@PathVariable Long id, @RequestBody Visita visitDetails) {
        Visita updatedVisita = visitaService.actualizarVisita(visitDetails);
        return ResponseEntity.ok(updatedVisita);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisit(@PathVariable Long id) {
        visitaService.eliminarVisita(id);
        return ResponseEntity.noContent().build();
    }
}