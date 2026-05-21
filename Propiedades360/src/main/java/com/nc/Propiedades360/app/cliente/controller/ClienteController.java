package com.nc.Propiedades360.app.cliente.controller;

import com.nc.Propiedades360.app.cliente.entity.Cliente;
import com.nc.Propiedades360.app.cliente.http.request.PagoRequest;
import com.nc.Propiedades360.app.cliente.http.request.ReservaRequest;
import com.nc.Propiedades360.app.cliente.service.ClienteService;
import com.nc.Propiedades360.app.inmueble.entity.Inmueble;
import com.nc.Propiedades360.app.pago.entity.Pago;
import com.nc.Propiedades360.app.reserva.entity.Reserva;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.math.BigDecimal;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


    private final ClienteService clienteService;

    public ClienteController(ClienteService usuarioService) {
        this.clienteService = usuarioService;
    }



    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.getClienteById(id));
    }


    @PostMapping("/reservar")
    public ResponseEntity<Reserva> reservar(@RequestBody ReservaRequest request) {
        return ResponseEntity.ok(clienteService.reservarInmueble(
                request.getClienteId(),
                request.getInmuebleId(),
                request.getFechaInicio(),
                request.getFechaFin()
        ));
    }


    @PostMapping("/pagar")
    public ResponseEntity<Pago> pagar(@RequestBody PagoRequest request) {
        return ResponseEntity.ok(clienteService.realizarPago(
                request.getClienteId(),
                request.getReservaId(),
                request.getMonto(),
                request.getMetodoPago()
        ));
    }
}
