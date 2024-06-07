package com.nc.Propiedades360.resources.Cliente.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nc.Propiedades360.resources.inmueble.entity.Inmueble;
import com.nc.Propiedades360.resources.pago.entity.Pago;
import com.nc.Propiedades360.resources.reserva.entity.Reserva;
import com.nc.Propiedades360.resources.visita.entity.Visita;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private String telefono;

    @JsonManagedReference(value = "cliente-reservas")
    @OneToMany(targetEntity = Reserva.class, fetch = FetchType.LAZY, mappedBy = "cliente")
    private List<Reserva> reservas;

    @JsonManagedReference(value = "cliente-visitas")
    @OneToMany(targetEntity = Visita.class, fetch = FetchType.LAZY, mappedBy = "cliente")
    private List<Visita> visitas;


}
