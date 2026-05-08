package com.nc.Propiedades360.app.cliente.controller;

import com.nc.Propiedades360.app.cliente.entity.Cliente;
import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
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
