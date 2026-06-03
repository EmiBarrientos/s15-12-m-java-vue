package com.nc.Propiedades360.app.usuario.dto;

import com.nc.Propiedades360.app.usuario.enums.Rol;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Long id;
    private String username;
    private String nombre;
    private String email;
    private String contrasena;
    private String telefono;
    @Enumerated(EnumType.STRING)
    private Rol rol;
}
