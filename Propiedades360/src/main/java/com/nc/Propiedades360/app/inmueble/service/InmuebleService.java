package com.nc.Propiedades360.app.inmueble.service;

import com.nc.Propiedades360.app.exception.InvalidStateException;
import com.nc.Propiedades360.app.exception.ResourceNotAvailableException;
import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
import com.nc.Propiedades360.app.inmueble.enums.EstadoInmueble;
import com.nc.Propiedades360.app.inmueble.repository.InmuebleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InmuebleService {
    private final InmuebleRepository inmuebleRepository;

    public InmuebleService(InmuebleRepository inmuebleRepository) {
        this.inmuebleRepository = inmuebleRepository;
    }

    public List<Inmueble> findAll() {
        return inmuebleRepository.findAll();
    }

    public Inmueble findById(Long id) {
        return inmuebleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inmueble no encontrado"));
    }

    // Validación de datos para el inmueble (agregar si es necesario)

    public Inmueble save(Inmueble inmueble) {
        return inmuebleRepository.save(inmueble);
    }

    public void deleteById(Long id) {
        inmuebleRepository.deleteById(id);
    }

    public Inmueble verificarDisponibilidad(Long id) {
        Inmueble inmueble = findById(id);
        if (inmueble.getEstado() != EstadoInmueble.DISPONIBLE) {
            throw new ResourceNotAvailableException("El inmueble no está disponible");
        }
        return inmueble;
    }

    public Inmueble actualizarEstado(Long id, EstadoInmueble estado) {
        Inmueble inmueble = findById(id);
        inmueble.setEstado(estado);
        return inmuebleRepository.save(inmueble);
    }

}

 /*public Inmueble updateEstado(Long id, String estado) {
        Inmueble inmueble = inmuebleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inmueble no encontrado"));
        inmueble.setEstado(estado);
        return inmuebleRepository.save(inmueble);
    }*/