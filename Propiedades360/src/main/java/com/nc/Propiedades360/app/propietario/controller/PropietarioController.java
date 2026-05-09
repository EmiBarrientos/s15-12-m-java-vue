package com.nc.Propiedades360.app.propietario.controller;

import com.nc.Propiedades360.app.propietario.entity.Propietario;
import com.nc.Propiedades360.app.propietario.service.PropietarioService;
import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propietarios")
public class PropietarioController {

    private final PropietarioService propietarioService;


    public PropietarioController(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<Propietario> registrar(@RequestBody Propietario propietario) {
        Propietario newPropietario = propietarioService.savePropietario(propietario);
        return ResponseEntity.ok(newPropietario);
    }
    @GetMapping("/{propietarioId}")
    public ResponseEntity<Propietario> obtener(@PathVariable Long propietarioId) {
        return ResponseEntity.ok(propietarioService.getPropietarioById(propietarioId));
    }

    @GetMapping("/{propietarioId}/inmuebles")
    public ResponseEntity<List<Inmueble>> obtenerInmuebles(@PathVariable Long propietarioId) {
        return ResponseEntity.ok(propietarioService.getInmueblesByPropietario(propietarioId));
    }

    @PostMapping("/{propietarioId}/inmuebles")
    public ResponseEntity<Inmueble> publicarInmueble(@PathVariable Long propietarioId, @RequestBody Inmueble inmueble) {
        return ResponseEntity.ok(propietarioService.publicarInmueble(inmueble, propietarioId));
    }

    @PutMapping("/inmuebles/{inmuebleId}")
    public ResponseEntity<Inmueble> actualizarInmueble(@PathVariable Long inmuebleId, @RequestBody Inmueble inmueble) {
        return ResponseEntity.ok(propietarioService.actualizarInmueble(inmuebleId, inmueble));
    }

    @DeleteMapping("/inmuebles/{inmuebleId}")
    public ResponseEntity<Void> eliminarInmueble(@PathVariable Long inmuebleId) {
        propietarioService.eliminarInmueble(inmuebleId);
        return ResponseEntity.noContent().build();
    }


}
