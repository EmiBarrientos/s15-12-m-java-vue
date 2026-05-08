package com.nc.Propiedades360.app.visita.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.nc.Propiedades360.app.cliente.entity.Cliente;
import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaVisita;

    @JsonBackReference(value = "cliente-visitas")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @JsonBackReference(value = "inmueble-visitas")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inmueble_id")
    private Inmueble inmueble;


}
