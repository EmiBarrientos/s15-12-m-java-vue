package com.nc.Propiedades360.resources.inmueble.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nc.Propiedades360.resources.Propietario.Entity.Propietario;
import com.nc.Propiedades360.resources.reserva.entity.Reserva;
import com.nc.Propiedades360.resources.visita.entity.Visita;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
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

    // Antigüedad
    @Enumerated(EnumType.STRING)
    private Antiguedad antiguedad;

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
    private List<Reserva> reservas;

    // Visitas
    @JsonManagedReference(value = "inmueble-visitas")
    @OneToMany(targetEntity = Visita.class, fetch = FetchType.LAZY, mappedBy = "inmueble")
    private List<Visita> visitas;

    // Enum para Perfil de Usuario
    public enum PerfilUsuario {
        PROPIETARIO_PARTICULAR,
        AGENTE_INMOBILIARIO,
        CONSTRUCTORA_DESARROLLADORA
    }

    // Enum para Tipo de Operación
    public enum TipoOperacion {
        VENTA,
        RENTA
    }

    // Enum para Tipo de Inmueble
    public enum TipoInmueble {
        CASA,
        EDIFICIO,
        DEPARTAMENTO,
        LOCAL_COMERCIAL,
        TERRENO
    }

    // Enum para Antigüedad
    public enum Antiguedad {
        A_ESTRENAR,
        ANIOS_DE_ANTIGUEDAD,
        EN_CONSTRUCCION
    }
}
