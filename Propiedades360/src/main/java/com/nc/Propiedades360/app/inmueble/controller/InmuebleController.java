package com.nc.Propiedades360.app.inmueble.controller;

import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
import com.nc.Propiedades360.app.inmueble.enums.EstadoInmueble;
import com.nc.Propiedades360.app.inmueble.service.InmuebleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inmueble")
public class InmuebleController {

    private final InmuebleService inmuebleService;


    public InmuebleController(InmuebleService inmuebleService) {
        this.inmuebleService = inmuebleService;
    }

    @GetMapping
    public ResponseEntity<List<Inmueble>> obtenerTodos() {
        return ResponseEntity.ok(inmuebleService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Inmueble> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(inmuebleService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        inmuebleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Inmueble> actualizarEstado(@PathVariable Long id, @RequestParam EstadoInmueble estado) {
        return ResponseEntity.ok(inmuebleService.actualizarEstado(id, estado));
    }
}
