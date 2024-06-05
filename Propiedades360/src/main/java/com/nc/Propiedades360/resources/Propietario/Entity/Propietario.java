package com.nc.Propiedades360.resources.Propietario.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nc.Propiedades360.resources.Usuario.Entity.Usuario;
import com.nc.Propiedades360.resources.inmueble.entity.Inmueble;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "propietario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Propietario {

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

    @JsonManagedReference
    @OneToMany(targetEntity = Inmueble.class, fetch = FetchType.LAZY, mappedBy = "propietario")
    private List<Inmueble> inmuebles;

}
