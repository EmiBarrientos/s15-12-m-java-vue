package com.nc.Propiedades360.resources.visita.service;


import com.nc.Propiedades360.resources.visita.entity.Visita;
import com.nc.Propiedades360.resources.visita.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VisitaService {

    @Autowired
    private VisitaRepository visitaRepository;

    public Optional<Visita> findById(Long id) {
        return visitaRepository.findById(id);
    }

    public Visita save(Visita visita) {
        return visitaRepository.save(visita);
    }

    public boolean confirmarVisita(Long id) {
        Optional<Visita> visitaOptional = visitaRepository.findById(id);
        if (visitaOptional.isPresent()) {
            Visita visita = visitaOptional.get();
            visita.confirmarVisita();
            visitaRepository.save(visita);
            return true;
        }
        return false;
    }

    public boolean cancelarVisita(Long id) {
        Optional<Visita> visitaOptional = visitaRepository.findById(id);
        if (visitaOptional.isPresent()) {
            Visita visita = visitaOptional.get();
            visita.cancelarVisita();
            visitaRepository.save(visita);
            return true;
        }
        return false;
    }
}
