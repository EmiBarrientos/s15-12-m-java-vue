package com.nc.Propiedades360.resources.reserva.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nc.Propiedades360.resources.Cliente.Entity.Cliente;
import com.nc.Propiedades360.resources.inmueble.entity.Inmueble;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@Table(name = "reserva")
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @JsonBackReference(value = "cliente-reservas")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @JsonBackReference(value = "inmueble-reservas")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inmueble_id")
    private Inmueble inmueble;



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
