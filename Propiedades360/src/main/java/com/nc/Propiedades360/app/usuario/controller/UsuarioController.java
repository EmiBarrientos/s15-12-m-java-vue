package com.nc.Propiedades360.app.usuario.controller;

import com.nc.Propiedades360.app.usuario.entity.Usuario;
import com.nc.Propiedades360.app.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }




    @PutMapping("/actualizar-perfil")
    public ResponseEntity<Usuario> actualizarPerfil(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.actualizarPerfil(usuario));
    }
}
