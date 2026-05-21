package com.nc.Propiedades360.app.auth.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String nombre;
    private String email;
    private String contrasena;
    private String telefono;
}
