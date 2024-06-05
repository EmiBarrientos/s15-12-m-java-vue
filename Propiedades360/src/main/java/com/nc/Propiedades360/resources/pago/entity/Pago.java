package com.nc.Propiedades360.resources.pago.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal monto;
    private String metodoPago;
    private Long clienteId;
    private Long reservaId;

    @Enumerated(EnumType.STRING)
    private EstadoPago estadoPago;

    public enum EstadoPago {
        PENDIENTE,
        FALLIDO,
        COMPLETADO
    }


    public void procesarPago() {
        // Lógica para procesar el pago
        this.estadoPago = EstadoPago.COMPLETADO; // Suponiendo que el pago se procesa correctamente
    }

    public EstadoPago verificarEstadoPago() {
        return this.estadoPago;
    }
}
