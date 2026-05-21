package com.nc.Propiedades360.app.auth.service;

import com.nc.Propiedades360.app.auth.dto.AuthResponse;
import com.nc.Propiedades360.app.auth.dto.LoginRequest;
import com.nc.Propiedades360.app.auth.dto.RegisterRequest;
import com.nc.Propiedades360.app.auth.jwt.JwtService;
import com.nc.Propiedades360.app.cliente.entity.Cliente;
import com.nc.Propiedades360.app.cliente.service.ClienteService;
import com.nc.Propiedades360.app.propietario.entity.Propietario;
import com.nc.Propiedades360.app.propietario.service.PropietarioService;
import com.nc.Propiedades360.app.usuario.entity.Usuario;
import com.nc.Propiedades360.app.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final ClienteService clienteService;
    private final PropietarioService propietarioService;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthResponse iniciarSesion(LoginRequest request) {
       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getContrasena()));
        Usuario user= usuarioRepository.findByUsername(request.getUsername()).orElseThrow();
        String token= jwtService.getToken(user);
        String role = user.getRol().toString() ;
        Long id = user.getId();

        return AuthResponse.builder()
                .token(token)
                .role(role)
                .id(id)
                .build();
    }


    public AuthResponse registrarCliente(RegisterRequest request) {
        Cliente cliente = new Cliente();
        cliente.setUsername(request.getUsername());
        cliente.setNombre(request.getNombre());
        cliente.setEmail(request.getEmail());
        cliente.setContrasena(passwordEncoder.encode(request.getContrasena()));
        cliente.setTelefono(request.getTelefono());
        clienteService.saveCliente(cliente);
        return AuthResponse.builder()
                .token(jwtService.getToken(cliente))
                .build();
    }

    public AuthResponse registrarPropietario(RegisterRequest request) {
        Propietario propietario = new Propietario();
        propietario.setUsername(request.getUsername());
        propietario.setNombre(request.getNombre());
        propietario.setEmail(request.getEmail());
        propietario.setContrasena(passwordEncoder.encode(request.getContrasena()));
        propietario.setTelefono(request.getTelefono());
        propietarioService.savePropietario(propietario);
        return AuthResponse.builder()
                .token(jwtService.getToken(propietario))
                .build();
    }

}
