package com.nc.Propiedades360.app.pago.entity;


import com.nc.Propiedades360.app.cliente.entity.Cliente;
import com.nc.Propiedades360.app.pago.enums.EstadoPago;
import com.nc.Propiedades360.app.reserva.entity.Reserva;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal monto;
    private String metodoPago;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    @Enumerated(EnumType.STRING)
    private EstadoPago estadoPago;

}
