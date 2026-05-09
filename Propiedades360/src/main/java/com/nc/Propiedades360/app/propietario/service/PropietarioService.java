package com.nc.Propiedades360.app.propietario.service;

import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.propietario.entity.Propietario;
import com.nc.Propiedades360.app.propietario.repository.PropietarioRepository;
import com.nc.Propiedades360.app.usuario.enums.Rol;
import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
import com.nc.Propiedades360.app.inmueble.enums.EstadoInmueble;
import com.nc.Propiedades360.app.inmueble.service.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PropietarioService {

    private final PropietarioRepository propietarioRepository;
    private final InmuebleService inmuebleService;

    @Autowired
    public PropietarioService( PropietarioRepository propietarioRepository, InmuebleService inmuebleService) {
        this.inmuebleService = inmuebleService;
        this.propietarioRepository = propietarioRepository;
    }

    // Validación de datos para el propietario (agregar si es necesario)

    public Propietario savePropietario(Propietario propietario) {
        propietario.setRol(Rol.PROPIETARIO);
        return propietarioRepository.save(propietario);
    }


    public Propietario getPropietarioById(Long id) {
        return propietarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Propietario no encontrado"));
    }

    public List<Inmueble> getInmueblesByPropietario(Long propietarioId) {
        Propietario propietario = getPropietarioById(propietarioId);
        return propietario.getInmuebles();
    }

    @Transactional
    public Inmueble publicarInmueble(Inmueble inmueble, Long propietarioId) {
        Propietario propietario = getPropietarioById(propietarioId);
        inmueble.setPropietario(propietario);
        inmueble.setEstado(EstadoInmueble.DISPONIBLE);
        return inmuebleService.save(inmueble);
    }


    @Transactional
    public Inmueble actualizarInmueble(Long inmuebleId, Inmueble inmuebleDetalles) {
        Inmueble inmueble = inmuebleService.findById(inmuebleId)
                ;
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
        return inmuebleService.save(inmueble);
    }


    @Transactional
    public void eliminarInmueble(Long inmuebleId) {
        inmuebleService.deleteById(inmuebleId);
    }
}