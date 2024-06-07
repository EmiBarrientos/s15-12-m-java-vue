package com.nc.Propiedades360.resources.Propietario.Service;

import com.nc.Propiedades360.resources.Propietario.Entity.Propietario;
import com.nc.Propiedades360.resources.Propietario.Repository.PropietarioRepository;
import com.nc.Propiedades360.resources.inmueble.entity.Inmueble;
import com.nc.Propiedades360.resources.inmueble.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
@Service
public class PropietarioService {

    private final InmuebleRepository inmuebleRepository;
    private final PropietarioRepository propietarioRepository;

    @Autowired
    public PropietarioService(InmuebleRepository inmuebleRepository, PropietarioRepository propietarioRepository) {
        this.inmuebleRepository = inmuebleRepository;
        this.propietarioRepository = propietarioRepository;
    }

    public Propietario savePropietario(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    public Propietario getPropietarioById(Long id) {
        return propietarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Propietario no encontrado"));
    }

    @Transactional
    public Inmueble publicarInmueble(Inmueble inmueble, Long propietarioId) {
        Propietario propietario = propietarioRepository.findById(propietarioId)
                .orElseThrow(() -> new RuntimeException("Propietario no encontrado"));
        inmueble.setPropietario(propietario);
        return inmuebleRepository.save(inmueble);
    }

    @Transactional
    public Inmueble actualizarInmueble(Long inmuebleId, Inmueble inmuebleDetalles) {
        Inmueble inmueble = inmuebleRepository.findById(inmuebleId)
                .orElseThrow(() -> new RuntimeException("Inmueble no encontrado"));

        inmueble.setTipo(inmuebleDetalles.getTipo());
        inmueble.setFoto(inmuebleDetalles.getFoto());
        inmueble.setPrecio(inmuebleDetalles.getPrecio());
        inmueble.setNumeroDeHabitaciones(inmuebleDetalles.getNumeroDeHabitaciones());
        inmueble.setNumeroDeBanios(inmuebleDetalles.getNumeroDeBanios());
        inmueble.setEstado(inmuebleDetalles.getEstado());
        inmueble.setSuperficie(inmuebleDetalles.getSuperficie());
        inmueble.setDatosDeContacto(inmuebleDetalles.getDatosDeContacto());

        return inmuebleRepository.save(inmueble);
    }

    @Transactional
    public void eliminarInmueble(Long inmuebleId) {
        Inmueble inmueble = inmuebleRepository.findById(inmuebleId)
                .orElseThrow(() -> new RuntimeException("Inmueble no encontrado"));

        inmuebleRepository.delete(inmueble);
    }
}
