package com.nc.Propiedades360.app.inmueble.repository;

import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {
}
