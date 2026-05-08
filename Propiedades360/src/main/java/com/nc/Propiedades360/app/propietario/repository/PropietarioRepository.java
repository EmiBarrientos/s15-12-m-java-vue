package com.nc.Propiedades360.app.propietario.repository;

import com.nc.Propiedades360.app.propietario.entity.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {
}
