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

    // Validación de datos para el propietario (agregar si es necesario)

    public Propietario savePropietario(Propietario propietario) {
        // Validar datos del propietario antes de guardarlo
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

        // Validar datos del inmueble antes de guardarlo
        inmueble.setPropietario(propietario);
        return inmuebleRepository.save(inmueble);
    }

    @Transactional
    public Inmueble actualizarInmueble(Long inmuebleId, Inmueble inmuebleDetalles) {
        Inmueble inmueble = inmuebleRepository.findById(inmuebleId)
                .orElseThrow(() -> new RuntimeException("Inmueble no encontrado"));

        // Validar datos del inmueble antes de actualizarlo
        inmueble.setTipoInmueble(inmuebleDetalles.getTipoInmueble());
        inmueble.setUbicacion(inmuebleDetalles.getUbicacion());
        inmueble.setTipoOperacion(inmuebleDetalles.getTipoOperacion());
        inmueble.setFoto(inmuebleDetalles.getFoto());
        inmueble.setPrecio(inmuebleDetalles.getPrecio());
        inmueble.setNumeroRecamaras(inmuebleDetalles.getNumeroRecamaras());
        inmueble.setNumeroBanios(inmuebleDetalles.getNumeroBanios());
        inmueble.setSuperficieConstruida(inmuebleDetalles.getSuperficieConstruida());
        inmueble.setSuperficieTerreno(inmuebleDetalles.getSuperficieTerreno());
        inmueble.setAntiguedad(inmuebleDetalles.getAntiguedad());
        inmueble.setMantenimiento(inmuebleDetalles.getMantenimiento());
        inmueble.setTitulo(inmuebleDetalles.getTitulo());
        inmueble.setDescripcion(inmuebleDetalles.getDescripcion());
        inmueble.setUrlVideo(inmuebleDetalles.getUrlVideo());
        inmueble.setFotoPlanos(inmuebleDetalles.getFotoPlanos());

        return inmuebleRepository.save(inmueble);
    }

    @Transactional
    public void eliminarInmueble(Long inmuebleId) {
        Inmueble inmueble = inmuebleRepository.findById(inmuebleId)
                .orElseThrow(() -> new RuntimeException("Inmueble no encontrado"));

        inmuebleRepository.delete(inmueble);
    }
}