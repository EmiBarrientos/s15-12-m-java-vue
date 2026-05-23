package com.nc.Propiedades360.app.visita.controller;

import com.nc.Propiedades360.app.visita.entity.Visita;
import com.nc.Propiedades360.app.visita.service.VisitaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitas")
public class VisitaController {

    private final VisitaService visitaService;


    public VisitaController(VisitaService visitaService) {
        this.visitaService = visitaService;
    }

    @GetMapping
    public ResponseEntity<List<Visita>> obtenerTodas() {
        return ResponseEntity.ok(visitaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visita> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(visitaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Visita> crear(@RequestBody Visita visita) {
        return ResponseEntity.ok(visitaService.crearVisita(visita));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Visita> actualizar(@PathVariable Long id, @RequestBody Visita visita) {
        visita.setId(id);
        return ResponseEntity.ok(visitaService.actualizarVisita(visita));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        visitaService.eliminarVisita(id);
        return ResponseEntity.noContent().build();
    }
}