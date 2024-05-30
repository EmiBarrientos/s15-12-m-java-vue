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
    @Autowired
    private InmuebleService inmuebleService;

    @GetMapping
    public List<Inmueble> getAllProperties() {
        return inmuebleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inmueble> getPropertyById(@PathVariable Long id) {
        Optional<Inmueble> inmueble = inmuebleService.findById(id);
        if (inmueble.isPresent()) {
            return ResponseEntity.ok(inmueble.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Inmueble createInmueble(@RequestBody Inmueble inmueble) {
        return inmuebleService.save(inmueble);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inmueble> updateProperty(@PathVariable Long id, @RequestBody Inmueble propertyDetails) {
        Optional<Inmueble> propertyOptional = inmuebleService.findById(id);
        if (propertyOptional.isPresent()) {
            Inmueble property = propertyOptional.get();
            property.setPropietarioId(propertyDetails.getPropietarioId());
            property.setTipo(propertyDetails.getTipo());
            property.setDireccion(propertyDetails.getDireccion());
            property.setFoto(propertyDetails.getFoto());
            property.setPrecio(propertyDetails.getPrecio());
            property.setNumeroDeHabitaciones(propertyDetails.getNumeroDeHabitaciones());
            property.setNumeroDeBanios(propertyDetails.getNumeroDeBanios());
            property.setEstado(propertyDetails.getEstado());
            property.setSuperficie(propertyDetails.getSuperficie());
            property.setDatosDeContacto(propertyDetails.getDatosDeContacto());
            Inmueble updatedInmueble = inmuebleService.save(property);
            return ResponseEntity.ok(updatedInmueble);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        inmuebleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/actualizarEstado/{id}")
    public ResponseEntity<Void> actualizarEstadoInmueble(@PathVariable Long id, @RequestBody String estado) {
        Optional<Inmueble> updatedInmueble = inmuebleService.updateEstado(id, estado);
        if (updatedInmueble.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
