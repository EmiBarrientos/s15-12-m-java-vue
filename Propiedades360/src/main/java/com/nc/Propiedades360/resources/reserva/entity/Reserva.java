package com.nc.Propiedades360.resources.reserva.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nc.Propiedades360.resources.Cliente.Entity.Cliente;
import com.nc.Propiedades360.resources.inmueble.entity.Inmueble;
import com.nc.Propiedades360.resources.pago.entity.Pago;
import com.nc.Propiedades360.resources.reserva.enums.Estado;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reserva")
@Data
@EqualsAndHashCode(exclude = {"pagos"})
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


    @JsonManagedReference(value = "reserva-pagos")
    @OneToMany(mappedBy = "reserva", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Pago> pagos;
}
