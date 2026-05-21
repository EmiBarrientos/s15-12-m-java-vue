package com.nc.Propiedades360.app.auth.dto;

import com.nc.Propiedades360.app.usuario.enums.Rol;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    private Long id;
    private String nombre;
    private String email;
    private String contrasena;
    private String telefono;
    private Rol rol;

}
