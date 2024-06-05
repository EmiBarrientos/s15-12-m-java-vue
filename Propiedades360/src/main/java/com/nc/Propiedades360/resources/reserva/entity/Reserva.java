package com.nc.Propiedades360.resources.reserva.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Long clienteId;
    private Long inmuebleId;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    public enum Estado {
        PENDIENTE,
        CONFIRMADA,
        CANCELADA
    }

    // Getters y Setters

    public void confirmarReserva() {
        this.estado = Estado.CONFIRMADA;
    }

    public void cancelarReserva() {
        this.estado = Estado.CANCELADA;
    }
}
