package com.nc.Propiedades360.resources.Usuario.Controller;

import com.nc.Propiedades360.resources.Usuario.Entity.Usuario;
import com.nc.Propiedades360.resources.Usuario.Service.UsuarioService;
import com.nc.Propiedades360.resources.Usuario.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Usuario> iniciarSesion(@RequestBody LoginDto dto) {
        return usuarioService.iniciarSesion(dto.getEmail(), dto.getContrasena());
    }

    @PutMapping("/actualizar-perfil")
    public Usuario actualizarPerfil(@RequestBody Usuario usuario) {
        return usuarioService.actualizarPerfil(usuario);
    }
}

/**
 *
 *
 *   @PostMapping("/registrarse")
 *     public Usuario registrarse(@RequestBody Usuario usuario) {
 *         return usuarioService.registrarse(usuario);
 *     }
 *
 *
 *
 * */