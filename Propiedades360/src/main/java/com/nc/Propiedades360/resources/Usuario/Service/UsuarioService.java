package com.nc.Propiedades360.resources.Usuario.Service;

import com.nc.Propiedades360.resources.Usuario.Entity.Usuario;
import com.nc.Propiedades360.resources.Usuario.Repository.UsuarioRepository;
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

    public Usuario registrarse(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> iniciarSesion(String email, String contrasena) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent() && usuario.get().getContrasena().equals(contrasena)) {
            return usuario;
        }
        return Optional.empty();
    }

    public Usuario actualizarPerfil(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


}
