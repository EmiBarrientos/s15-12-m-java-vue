package com.nc.Propiedades360.app.reserva.repository;


import com.nc.Propiedades360.app.reserva.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
