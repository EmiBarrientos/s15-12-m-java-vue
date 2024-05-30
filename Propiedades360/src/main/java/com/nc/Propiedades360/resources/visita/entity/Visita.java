package com.nc.Propiedades360.resources.visita.entity;



import com.nc.Propiedades360.resources.reserva.entity.Reserva;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Visita extends Reserva {

    private String propietario;

    // Constructor
    public Visita() {
    }

    public Visita(LocalDate fechaInicio, LocalDate fechaFin, Long clienteId, Long inmuebleId, String propietario) {
        super.setFechaInicio(fechaInicio);
        super.setFechaFin(fechaFin);
        super.setClienteId(clienteId);
        super.setInmuebleId(inmuebleId);
        this.propietario = propietario;
        super.setEstado(Estado.PENDIENTE);
    }

    // Getters y Setters
    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    // Métodos adicionales para Visita
    public void confirmarVisita() {
        this.setEstado(Estado.CONFIRMADA);
    }

    public void cancelarVisita() {
        this.setEstado(Estado.CANCELADA);
    }
}
