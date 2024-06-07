package com.nc.Propiedades360.resources.pago.service;


import com.nc.Propiedades360.resources.pago.entity.Pago;
import com.nc.Propiedades360.resources.pago.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public Optional<Pago> findById(Long id) {
        return pagoRepository.findById(id);
    }

    public Pago save(Pago pago) {
        return pagoRepository.save(pago);
    }

    public boolean procesarPago(Long id) {
        Optional<Pago> pagoOptional = pagoRepository.findById(id);
        if (pagoOptional.isPresent()) {
            Pago pago = pagoOptional.get();
            pago.procesarPago();
            pagoRepository.save(pago);
            return true;
        }
        return false;
    }

    public Optional<Pago.EstadoPago> verificarEstadoPago(Long id) {
        Optional<Pago> pagoOptional = pagoRepository.findById(id);
        return pagoOptional.map(Pago::verificarEstadoPago);
    }
}
