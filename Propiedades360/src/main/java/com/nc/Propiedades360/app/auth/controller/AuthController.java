package com.nc.Propiedades360.app.auth.controller;

import com.nc.Propiedades360.app.auth.dto.AuthResponse;
import com.nc.Propiedades360.app.auth.dto.RegisterRequest;
import com.nc.Propiedades360.app.auth.service.AuthService;
import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.auth.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> iniciarSesion(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.iniciarSesion(request));
    }

    @PostMapping("/register/cliente")
    public ResponseEntity<AuthResponse> registrarCliente(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.registrarCliente(request));
    }

    @PostMapping("/register/propietario")
    public ResponseEntity<AuthResponse> registrarPropietario(@RequestBody RegisterRequest request) {

        return ResponseEntity.ok(authService.registrarPropietario(request));
    }

}
