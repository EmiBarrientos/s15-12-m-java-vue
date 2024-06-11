package com.nc.Propiedades360.resources.inmueble.service;

import com.nc.Propiedades360.resources.inmueble.entity.Inmueble;
import com.nc.Propiedades360.resources.inmueble.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InmuebleService {
    private final InmuebleRepository inmuebleRepository;

    @Autowired
    public InmuebleService(InmuebleRepository inmuebleRepository) {
        this.inmuebleRepository = inmuebleRepository;
    }

    public List<Inmueble> findAll() {
        return inmuebleRepository.findAll();
    }

    public Inmueble findById(Long id) {
        return inmuebleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inmueble no encontrado"));
    }

    // Validación de datos para el inmueble (agregar si es necesario)

    public Inmueble save(Inmueble inmueble) {
        return inmuebleRepository.save(inmueble);
    }

    public void deleteById(Long id) {
        inmuebleRepository.deleteById(id);
    }

    /*public Inmueble updateEstado(Long id, String estado) {
        Inmueble inmueble = inmuebleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inmueble no encontrado"));
        inmueble.setEstado(estado);
        return inmuebleRepository.save(inmueble);
    }*/
}