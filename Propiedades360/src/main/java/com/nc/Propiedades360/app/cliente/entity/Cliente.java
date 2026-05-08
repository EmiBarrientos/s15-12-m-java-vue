package com.nc.Propiedades360.app.cliente.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nc.Propiedades360.app.usuario.entity.Usuario;
import com.nc.Propiedades360.app.pago.entity.Pago;
import com.nc.Propiedades360.app.reserva.entity.Reserva;
import com.nc.Propiedades360.app.visita.entity.Visita;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cliente")
@Data
@EqualsAndHashCode(exclude = {"reservas", "visitas", "pagos"})
public class Cliente extends Usuario {


    @JsonManagedReference(value = "cliente-reservas")
    @OneToMany(targetEntity = Reserva.class, fetch = FetchType.LAZY, mappedBy = "cliente")
    @ToString.Exclude
    private List<Reserva> reservas;

    @JsonManagedReference(value = "cliente-visitas")
    @OneToMany(targetEntity = Visita.class, fetch = FetchType.LAZY, mappedBy = "cliente")
    @ToString.Exclude
    private List<Visita> visitas;

    @JsonManagedReference(value = "cliente-pagos")
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Pago> pagos;

}
