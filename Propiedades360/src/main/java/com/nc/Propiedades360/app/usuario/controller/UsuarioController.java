package com.nc.Propiedades360.app.usuario.controller;

import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.usuario.entity.Usuario;
import com.nc.Propiedades360.app.usuario.service.UsuarioService;
import com.nc.Propiedades360.app.usuario.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping("/iniciar-sesion")
    public ResponseEntity<Usuario> iniciarSesion(@RequestBody LoginDto dto) {
        return usuarioService.iniciarSesion(dto.getEmail(), dto.getContrasena())
                .map(ResponseEntity::ok)
                .orElseThrow(()-> new ResourceNotFoundException("Usuario o email incorrecto"));
    }

    @PutMapping("/actualizar-perfil")
    public ResponseEntity<Usuario> actualizarPerfil(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.actualizarPerfil(usuario));
    }
}
