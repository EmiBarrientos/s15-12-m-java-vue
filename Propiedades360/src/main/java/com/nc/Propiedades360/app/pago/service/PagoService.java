package com.nc.Propiedades360.app.pago.service;


import com.nc.Propiedades360.app.cliente.entity.Cliente;
import com.nc.Propiedades360.app.inmueble.enums.EstadoInmueble;
import com.nc.Propiedades360.app.inmueble.service.InmuebleService;
import com.nc.Propiedades360.app.pago.entity.Pago;
import com.nc.Propiedades360.app.pago.enums.EstadoPago;
import com.nc.Propiedades360.app.pago.repository.PagoRepository;
import com.nc.Propiedades360.app.reserva.entity.Reserva;
import com.nc.Propiedades360.app.reserva.service.ReservaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class PagoService {


    private final PagoRepository pagoRepository;
    private final ReservaService reservaService;
    private final InmuebleService inmuebleService;

    public PagoService(PagoRepository pagoRepository, ReservaService reservaService, InmuebleService inmuebleService) {
        this.pagoRepository = pagoRepository;
        this.reservaService = reservaService;
        this.inmuebleService = inmuebleService;
    }

    public Optional<Pago> findById(Long id) {
        return pagoRepository.findById(id);
    }



    @Transactional
    public Pago procesarPago(Cliente cliente, Reserva reserva, BigDecimal monto, String metodoPago) {
        Pago pago = new Pago();
        pago.setCliente(cliente);
        pago.setReserva(reserva);
        pago.setMonto(monto);
        pago.setMetodoPago(metodoPago);
        pago.setEstadoPago(EstadoPago.PENDIENTE);

        pagoRepository.save(pago);

        // procesar el pago — acá iría la integración con una pasarela de pago real
        pago.setEstadoPago(EstadoPago.COMPLETADO);
        pagoRepository.save(pago);

        // si el pago completó, confirmar reserva y marcar inmueble como reservado
        if (pago.getEstadoPago() == EstadoPago.COMPLETADO) {
            reservaService.confirmarReserva(reserva.getId());
            inmuebleService.actualizarEstado(reserva.getInmueble().getId(), EstadoInmueble.RESERVADO);
        }

        return pago;
    }

    public Optional<EstadoPago> verificarEstadoPago(Long id) {
        return pagoRepository.findById(id).map(Pago::getEstadoPago);
    }
}
