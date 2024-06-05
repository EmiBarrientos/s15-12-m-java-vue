package com.nc.Propiedades360.resources.Cliente.Controller;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PagoRequest{
    private Long clienteId;
    private Long reservaId;
    private BigDecimal monto;
    private String metodoPago;
}
