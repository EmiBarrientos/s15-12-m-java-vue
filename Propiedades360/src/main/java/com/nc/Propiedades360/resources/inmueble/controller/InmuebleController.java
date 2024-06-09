package com.nc.Propiedades360.resources.inmueble.controller;

import com.nc.Propiedades360.resources.inmueble.entity.Inmueble;
import com.nc.Propiedades360.resources.inmueble.service.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inmueble")
public class InmuebleController {
    private InmuebleService inmuebleService;

    public InmuebleController(InmuebleService inmuebleService) {
        this.inmuebleService = inmuebleService;
    }

    @GetMapping
    public ResponseEntity<List<Inmueble>> getAllInmuebles() {
        List<Inmueble> inmuebles = inmuebleService.findAll();
        return ResponseEntity.ok(inmuebles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inmueble> getInmuebleById(@PathVariable Long id) {
        Inmueble inmueble = inmuebleService.findById(id);
        return ResponseEntity.ok(inmueble);
    }

    @PostMapping
    public ResponseEntity<Inmueble> createInmueble(@RequestBody Inmueble inmueble) {
        // Validar datos del inmueble antes de guardarlo (opcional)
        Inmueble newInmueble = inmuebleService.save(inmueble);
        return ResponseEntity.ok(newInmueble);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inmueble> updateInmueble(@PathVariable Long id, @RequestBody Inmueble propertyDetails) {
        Inmueble updatedInmueble = inmuebleService.findById(id);
        // Actualizar campos según la entidad Inmueble modificada
        updatedInmueble.setPerfilUsuario(propertyDetails.getPerfilUsuario());
        updatedInmueble.setTipoOperacion(propertyDetails.getTipoOperacion());
        updatedInmueble.setTipoInmueble(propertyDetails.getTipoInmueble());
        updatedInmueble.setUbicacion(propertyDetails.getUbicacion());
        updatedInmueble.setNumeroRecamaras(propertyDetails.getNumeroRecamaras());
        updatedInmueble.setNumeroBanios(propertyDetails.getNumeroBanios());
        updatedInmueble.setSuperficieConstruida(propertyDetails.getSuperficieConstruida());
        updatedInmueble.setSuperficieTerreno(propertyDetails.getSuperficieTerreno());
        updatedInmueble.setAntiguedad(propertyDetails.getAntiguedad());
        updatedInmueble.setMantenimiento(propertyDetails.getMantenimiento());
        updatedInmueble.setTitulo(propertyDetails.getTitulo());
        updatedInmueble.setDescripcion(propertyDetails.getDescripcion());
        updatedInmueble.setUrlVideo(propertyDetails.getUrlVideo());
        //updatedInmueble.setEstado(propertyDetails.getEstado());
        // Manejar la actualización de la imagen (foto) si es necesario
        updatedInmueble.setPrecio(propertyDetails.getPrecio());
        Inmueble savedInmueble = inmuebleService.save(updatedInmueble);
        return ResponseEntity.ok(savedInmueble);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInmueble(@PathVariable Long id) {
        inmuebleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /*@PutMapping("/actualizarEstado/{id}")
    public ResponseEntity<Void> actualizarEstadoInmueble(@PathVariable Long id, @RequestBody String estado) {
        inmuebleService.updateEstado(id, estado);
        return ResponseEntity.ok().build();
    }*/
}
