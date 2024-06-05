package com.nc.Propiedades360.resources.Cliente.Controller;

import com.nc.Propiedades360.resources.Cliente.Entity.Cliente;
import com.nc.Propiedades360.resources.inmueble.entity.Inmueble;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservaRequest {
    private Cliente cliente;
    private Inmueble inmueble;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
