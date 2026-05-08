package com.nc.Propiedades360.app.visita.service;


import com.nc.Propiedades360.app.inmueble.repository.InmuebleRepository;
import com.nc.Propiedades360.app.visita.entity.Visita;
import com.nc.Propiedades360.app.visita.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitaService {

    private final VisitaRepository visitaRepository;
    private final InmuebleRepository inmuebleRepository;

    @Autowired
    public VisitaService(VisitaRepository visitaRepository, InmuebleRepository inmuebleRepository) {
        this.visitaRepository = visitaRepository;
        this.inmuebleRepository = inmuebleRepository;
    }

    public List<Visita> findAll() {
        return visitaRepository.findAll();
    }

    public Visita findById(Long id) {
        return visitaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Visita no encontrada"));
    }

    public Visita crearVisita(Visita visita) {
        // Validar datos de la visita antes de guardarla
        return visitaRepository.save(visita);
    }

    public Visita actualizarVisita(Visita visitaDetalles) {
        Visita visita = visitaRepository.findById(visitaDetalles.getId())
                .orElseThrow(() -> new RuntimeException("Visita no encontrada"));

        // Validar datos de la visita antes de actualizarla
        visita.setFechaVisita(visitaDetalles.getFechaVisita());
        //visita.setCliente(visitaDetalles.getCliente());
        //visita.setInmueble(visitaDetalles.getInmueble());

        return visitaRepository.save(visita);
    }

    public void eliminarVisita(Long id) {
        visitaRepository.deleteById(id);
    }
}