package com.nc.Propiedades360.resources.Propietario.Controller;

import com.nc.Propiedades360.resources.Propietario.Entity.Propietario;
import com.nc.Propiedades360.resources.Propietario.Service.PropietarioService;
import com.nc.Propiedades360.resources.inmueble.entity.Inmueble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/propietario")
public class PropietarioController {

    private final PropietarioService propietarioService;

    @Autowired
    public PropietarioController(PropietarioService propietarioService) {
        this.propietarioService = propietarioService;
    }

    @PostMapping("/create")
    public ResponseEntity<Propietario> createPropietario(@RequestBody Propietario propietario) {
        Propietario newPropietario = propietarioService.savePropietario(propietario);
        return ResponseEntity.ok(newPropietario);
    }

    @GetMapping("/obtener-propietario/{propietarioId}")
    public ResponseEntity<Propietario> obtenerPropietario(@PathVariable Long propietarioId) {
        Propietario propietario = propietarioService.getPropietarioById(propietarioId);
        return ResponseEntity.ok(propietario);
    }

    @PostMapping("/publicar-inmueble")
    public ResponseEntity<Inmueble> publicarInmueble(@RequestBody Inmueble inmueble, @RequestParam Long propietarioId) {
        Inmueble newInmueble = propietarioService.publicarInmueble(inmueble, propietarioId);
        return ResponseEntity.ok(newInmueble);
    }

    @PutMapping("/actualizar-inmueble/{inmuebleId}")
    public ResponseEntity<Inmueble> actualizarInmueble(@PathVariable Long inmuebleId, @RequestBody Inmueble inmueble) {
        Inmueble updatedInmueble = propietarioService.actualizarInmueble(inmuebleId, inmueble);
        return ResponseEntity.ok(updatedInmueble);
    }

    @DeleteMapping("/eliminar-inmueble/{inmuebleId}")
    public ResponseEntity<Void> eliminarInmueble(@PathVariable Long inmuebleId) {
        propietarioService.eliminarInmueble(inmuebleId);
        return ResponseEntity.noContent().build();
    }


}
