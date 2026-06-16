package com.nc.Propiedades360.app.usuario.service;

import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.usuario.dto.UsuarioDto;
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

    public Usuario actualizarPerfil(Usuario usuario) {
        usuarioRepository.findById(usuario.getId())
                .orElseThrow(()->new ResourceNotFoundException("Usuario no encontrado"));
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioDto> findByUsername(String username) {


        return usuarioRepository.findByUsername(username)
                .map(usuario -> UsuarioDto.builder()
                                .id(usuario.getId())
                                .email(usuario.getContrasena())
                                .nombre(usuario.getNombre())
                                .username(usuario.getUsername())
                                .telefono(usuario.getTelefono())
                                .contrasena(usuario.getContrasena())
                                .build());

    }


}
