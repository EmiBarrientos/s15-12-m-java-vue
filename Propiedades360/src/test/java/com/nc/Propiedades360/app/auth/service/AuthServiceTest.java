package com.nc.Propiedades360.app.auth.service;

import com.nc.Propiedades360.app.auth.dto.AuthResponse;
import com.nc.Propiedades360.app.auth.dto.AuthResult;
import com.nc.Propiedades360.app.auth.dto.LoginRequest;
import com.nc.Propiedades360.app.auth.dto.RegisterRequest;
import com.nc.Propiedades360.app.auth.jwt.JwtService;
import com.nc.Propiedades360.app.cliente.entity.Cliente;
import com.nc.Propiedades360.app.cliente.service.ClienteService;
import com.nc.Propiedades360.app.propietario.entity.Propietario;
import com.nc.Propiedades360.app.propietario.service.PropietarioService;
import com.nc.Propiedades360.app.usuario.entity.Usuario;
import com.nc.Propiedades360.app.usuario.enums.Rol;
import com.nc.Propiedades360.app.usuario.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private ClienteService clienteService;

    @Mock
    private PropietarioService propietarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private AuthService authService;

    @Test
    void iniciarSesion_DeberiaRetornarTokenYDatosUsuario() {

        LoginRequest request = new LoginRequest();
        request.setUsername("emi");
        request.setContrasena("1234");

        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setUsername("emi");
        cliente.setRol(Rol.CLIENTE);

        when(usuarioRepository.findByUsername("emi"))
                .thenReturn(Optional.of(cliente));

        when(jwtService.getToken(cliente))
                .thenReturn("jwt-token");

        AuthResult result = authService.iniciarSesion(request);

        assertEquals("jwt-token", result.token());
        assertEquals("CLIENTE", result.userdata().getRole());
        assertEquals(1L, result.userdata().getId());

        verify(authenticationManager)
                .authenticate(any(
                        UsernamePasswordAuthenticationToken.class
                ));
    }

    @Test
    void iniciarSesion_DeberiaLanzarExcepcionCuandoUsuarioNoExiste() {

        LoginRequest request = new LoginRequest();
        request.setUsername("emi");
        request.setContrasena("1234");

        when(usuarioRepository.findByUsername("emi"))
                .thenReturn(Optional.empty());

        assertThrows(
                BadCredentialsException.class,
                () -> authService.iniciarSesion(request)
        );

        verify(authenticationManager)
                .authenticate(any(UsernamePasswordAuthenticationToken.class));
    }

    @Test
    void registrarCliente_DeberiaGuardarClienteConContrasenaEncriptada() {

        RegisterRequest request = new RegisterRequest();
        request.setUsername("emi");
        request.setNombre("Emilio");
        request.setEmail("emi@test.com");
        request.setContrasena("1234");
        request.setTelefono("223123456");

        when(passwordEncoder.encode("1234"))
                .thenReturn("password-encriptada");

        doAnswer(invocation -> {
            Cliente cliente = invocation.getArgument(0);
            cliente.setRol(Rol.CLIENTE);
            cliente.setId(1L);
            return cliente;
        }).when(clienteService).saveCliente(any(Cliente.class));

        AuthResponse response = authService.registrarCliente(request);

        assertEquals("CLIENTE", response.getRole());
        assertEquals(1L, response.getId());

        verify(clienteService).saveCliente(any(Cliente.class));
    }

    @Test
    void registrarPropietario_DeberiaGuardarPropietarioConContrasenaEncriptada() {

        RegisterRequest request = new RegisterRequest();
        request.setUsername("propietario");
        request.setNombre("Juan");
        request.setEmail("juan@test.com");
        request.setContrasena("1234");
        request.setTelefono("223123456");



        when(passwordEncoder.encode("1234"))
                .thenReturn("password-encriptada");

        doAnswer(invocation -> {
            Propietario propietario = invocation.getArgument(0);
            propietario.setRol(Rol.PROPIETARIO);
            propietario.setId(1L);
            return propietario;
        }).when(propietarioService).savePropietario(any(Propietario.class));


        authService.registrarPropietario(request);

        ArgumentCaptor<Propietario> captor =
                ArgumentCaptor.forClass(Propietario.class);

        verify(propietarioService)
                .savePropietario(captor.capture());

        Propietario propietario = captor.getValue();

        assertEquals("propietario", propietario.getUsername());
        assertEquals("Juan", propietario.getNombre());
        assertEquals("juan@test.com", propietario.getEmail());
        assertEquals("223123456", propietario.getTelefono());
        assertEquals("password-encriptada", propietario.getContrasena());

        verify(passwordEncoder)
                .encode("1234");
    }

}