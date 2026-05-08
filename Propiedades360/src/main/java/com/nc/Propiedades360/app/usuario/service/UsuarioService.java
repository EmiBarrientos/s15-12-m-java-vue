package com.nc.Propiedades360.app.usuario.service;

import com.nc.Propiedades360.app.usuario.entity.Usuario;
import com.nc.Propiedades360.app.usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.usuarioRepository = repository;
    }



    public Optional<Usuario> iniciarSesion(String email, String contrasena) {
        return usuarioRepository.findByEmail(email)
                .filter(u -> u.getContrasena().equals(contrasena));
    }

    public Usuario actualizarPerfil(Usuario usuario) {
        usuarioRepository.findById(usuario.getId())
                .orElseThrow(()->new RuntimeException("Usuario no encontrado"));
        return usuarioRepository.save(usuario);
    }


}

/*
*
*     public Usuario registrarse(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
*
*
*
* */