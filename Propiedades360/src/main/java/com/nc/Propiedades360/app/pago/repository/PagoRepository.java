package com.nc.Propiedades360.app.pago.repository;


import com.nc.Propiedades360.app.pago.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago, Long> {
}
