package com.nc.Propiedades360.resources.inmueble.controller;

import com.nc.Propiedades360.resources.inmueble.entity.Inmueble;
import com.nc.Propiedades360.resources.inmueble.service.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/inmueble")
public class InmuebleController {
    private InmuebleService inmuebleService;

    public InmuebleController(InmuebleService inmuebleService) {
        this.inmuebleService = inmuebleService;
    }

    @GetMapping
    public ResponseEntity<List<Inmueble>> getAllProperties() {
        List<Inmueble> inmuebles = inmuebleService.findAll();
        return ResponseEntity.ok(inmuebles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inmueble> getPropertyById(@PathVariable Long id) {
        Inmueble inmueble = inmuebleService.findById(id);
        return ResponseEntity.ok(inmueble);
    }

    @PostMapping
    public ResponseEntity<Inmueble> createInmueble(@RequestBody Inmueble inmueble) {
        Inmueble newInmueble = inmuebleService.save(inmueble);
        return ResponseEntity.ok(newInmueble);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inmueble> updateProperty(@PathVariable Long id, @RequestBody Inmueble propertyDetails) {
        Inmueble updatedInmueble = inmuebleService.findById(id);
        updatedInmueble.setTipo(propertyDetails.getTipo());
        updatedInmueble.setDireccion(propertyDetails.getDireccion());
        updatedInmueble.setFoto(propertyDetails.getFoto());
        updatedInmueble.setPrecio(propertyDetails.getPrecio());
        updatedInmueble.setNumeroDeHabitaciones(propertyDetails.getNumeroDeHabitaciones());
        updatedInmueble.setNumeroDeBanios(propertyDetails.getNumeroDeBanios());
        updatedInmueble.setEstado(propertyDetails.getEstado());
        updatedInmueble.setSuperficie(propertyDetails.getSuperficie());
        updatedInmueble.setDatosDeContacto(propertyDetails.getDatosDeContacto());
        Inmueble savedInmueble = inmuebleService.save(updatedInmueble);
        return ResponseEntity.ok(savedInmueble);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        inmuebleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/actualizarEstado/{id}")
    public ResponseEntity<Void> actualizarEstadoInmueble(@PathVariable Long id, @RequestBody String estado) {
        inmuebleService.updateEstado(id, estado);
        return ResponseEntity.ok().build();
    }
}
