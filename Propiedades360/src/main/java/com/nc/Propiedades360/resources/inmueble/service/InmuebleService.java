package com.nc.Propiedades360.resources.inmueble.service;

import com.nc.Propiedades360.resources.inmueble.entity.Inmueble;
import com.nc.Propiedades360.resources.inmueble.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InmuebleService {
    @Autowired
    private InmuebleRepository inmuebleRepository;

    public List<Inmueble> findAll() {
        return inmuebleRepository.findAll();
    }

    public Optional<Inmueble> findById(Long id) {
        return inmuebleRepository.findById(id);
    }

    public Inmueble save(Inmueble inmueble) {
        return inmuebleRepository.save(inmueble);
    }

    public void deleteById(Long id) {
        inmuebleRepository.deleteById(id);
    }

    public Optional<Inmueble> updateEstado(Long id, String estado) {
        Optional<Inmueble> inmuebleOptional = inmuebleRepository.findById(id);
        if (inmuebleOptional.isPresent()) {
            Inmueble inmueble = inmuebleOptional.get();
            inmueble.setEstado(estado);
            inmuebleRepository.save(inmueble);
            return Optional.of(inmueble);
        } else {
            return Optional.empty();
        }
    }
}
