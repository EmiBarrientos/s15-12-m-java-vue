package com.nc.Propiedades360.resources.inmueble.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nc.Propiedades360.resources.Propietario.Entity.Propietario;
import com.nc.Propiedades360.resources.inmueble.enums.*;
import com.nc.Propiedades360.resources.reserva.entity.Reserva;
import com.nc.Propiedades360.resources.visita.entity.Visita;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = {"visitas","reservas"})
public class Inmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Perfil del propietario
    @Enumerated(EnumType.STRING)
    private PerfilUsuario perfilUsuario;

    // Tipo de operación
    @Enumerated(EnumType.STRING)
    private TipoOperacion tipoOperacion;

    // Tipo de inmueble
    @Enumerated(EnumType.STRING)
    private TipoInmueble tipoInmueble;
    // Antigüedad
    @Enumerated(EnumType.STRING)
    private Antiguedad antiguedad;

    // Ubicación
    private String ubicacion;

    // Número de recamaras
    private int numeroRecamaras;

    // Número de baños
    private int numeroBanios;

    // Superficie construida (m2)
    private Double superficieConstruida;

    // Superficie terreno (m2)
    private Double superficieTerreno;


    // Precio de inmueble
    private Double precio;

    // Mantenimiento (opcional)
    private Double mantenimiento;

    // Titulo
    private String titulo;

    // Descripción de la propiedad
    private String descripcion;

    // Fotografías
    //@Lob
    //@Basic(fetch = FetchType.LAZY)
    private String foto;

    // URL del video (opcional)
    private String urlVideo;

    // Fotos de planos
    //@Lob
    //@Basic(fetch = FetchType.LAZY)
    private String fotoPlanos;


    // Propietario
    @JsonBackReference(value = "propietario-inmuebles")
    @ManyToOne(fetch = FetchType.LAZY)
    private Propietario propietario;

    // Reservas
    @JsonManagedReference(value = "inmueble-reservas")
    @OneToMany(targetEntity = Reserva.class, fetch = FetchType.LAZY, mappedBy = "inmueble")
    @ToString.Exclude
    private List<Reserva> reservas;

    // Visitas
    @JsonManagedReference(value = "inmueble-visitas")
    @OneToMany(targetEntity = Visita.class, fetch = FetchType.LAZY, mappedBy = "inmueble")
    @ToString.Exclude
    private List<Visita> visitas;

    @Enumerated(EnumType.STRING)
    private EstadoInmueble estado;

}
