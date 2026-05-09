package com.nc.Propiedades360.app.cliente.http.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservaRequest {
    private Long clienteId;
    private Long inmuebleId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
