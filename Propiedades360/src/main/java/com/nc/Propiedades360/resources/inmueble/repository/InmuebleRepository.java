package com.nc.Propiedades360.resources.inmueble.repository;

import com.nc.Propiedades360.resources.inmueble.entity.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {
}
