package com.nc.Propiedades360.app.propietario.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nc.Propiedades360.app.usuario.entity.Usuario;
import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "propietario")
@Data
@EqualsAndHashCode(exclude = {"inmuebles"})
public class Propietario extends Usuario{


    @JsonManagedReference(value = "propietario-inmuebles")
    @OneToMany(targetEntity = Inmueble.class, fetch = FetchType.LAZY, mappedBy = "propietario")
    @ToString.Exclude
    private List<Inmueble> inmuebles;

}
