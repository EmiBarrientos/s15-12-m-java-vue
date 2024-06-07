package com.nc.Propiedades360.resources.reserva.repository;


import com.nc.Propiedades360.resources.reserva.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
