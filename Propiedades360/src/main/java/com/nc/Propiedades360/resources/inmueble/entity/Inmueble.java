package com.nc.Propiedades360.resources.inmueble.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Inmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//   TODO: ESTA COLUMNA DEBE CAMBIARSE
    @Column(nullable = false)
    private Long propietarioId;

    // TODO: EL TIPO PUEDE SER ENUM
    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String foto;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private int numeroDeHabitaciones;

    @Column(nullable = false)
    private int numeroDeBanios;

    // TODO: EL TIPO PUEDE SER ENUM
    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private Double superficie;

    //TODO: PUEDE SER UNA ENTIDAD APARTE
    @Column(nullable = false)
    private String datosDeContacto;
}
