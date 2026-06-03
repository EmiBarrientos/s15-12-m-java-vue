package com.nc.Propiedades360.app.auth.controller;

import com.nc.Propiedades360.app.auth.dto.AuthResponse;
import com.nc.Propiedades360.app.auth.dto.AuthResult;
import com.nc.Propiedades360.app.auth.dto.RegisterRequest;
import com.nc.Propiedades360.app.auth.jwt.JwtService;
import com.nc.Propiedades360.app.auth.service.AuthService;
import com.nc.Propiedades360.app.exception.ResourceNotFoundException;
import com.nc.Propiedades360.app.auth.dto.LoginRequest;
import com.nc.Propiedades360.app.usuario.dto.UsuarioDto;
import com.nc.Propiedades360.app.usuario.repository.UsuarioRepository;
import com.nc.Propiedades360.app.usuario.service.UsuarioService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

private final AuthService authService;
private final JwtService jwtService;
private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> iniciarSesion(@RequestBody LoginRequest request, HttpServletResponse response) {

        AuthResult result = authService.iniciarSesion(request);

        //     Acá se arma la cookie
                ResponseCookie cookie = ResponseCookie.from("jwt", result.token())
                        .httpOnly(true)          // JS no puede leerla
                        .secure(true)            // solo HTTPS (en dev podés ponerlo false)
                        .path("/")               // disponible en toda la app
                        .maxAge(Duration.ofHours(24))
                        .sameSite("Strict")      // protección CSRF básica
                        .build();

                response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

        return ResponseEntity.ok(result.userdata());
    }
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletResponse response) {
        // Sobreescribís la cookie con maxAge 0 → el browser la borra
        ResponseCookie cookie = ResponseCookie.from("jwt", "")
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(0)
                .sameSite("Strict")
                .build();

        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/me")
    public ResponseEntity<?> validarYObtenerUsuario(
            @CookieValue(name = "token", required = false) String token) {

        // 1. Si la cookie ni siquiera llegó, rebotamos al front de una
        if (token == null || jwtService.isTokenExpired(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Sesión inválida o expirada");
        }

        // 2. Extraemos el username (o el ID) que guardaste adentro del payload del JWT
        String username = jwtService.getUsernameFromToken(token);

        // 3. Buscamos los datos limpios del usuario para devolvérselos al front
        // (nombre, email, roles/permisos)
        Optional<UsuarioDto> usuarioDto = usuarioService.findByUsername(username);

        // 4. Respondemos un 200 OK con los datos del usuario
        return ResponseEntity.ok(usuarioDto);
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
