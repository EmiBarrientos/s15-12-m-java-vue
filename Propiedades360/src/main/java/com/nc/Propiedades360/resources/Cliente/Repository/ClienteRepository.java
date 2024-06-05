package com.nc.Propiedades360.resources.Cliente.Repository;

import com.nc.Propiedades360.resources.Cliente.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
