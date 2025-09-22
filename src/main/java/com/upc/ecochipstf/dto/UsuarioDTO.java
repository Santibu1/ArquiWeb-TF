package com.upc.ecochipstf.dto;

import com.upc.ecochipstf.entities.Rol;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long usuarioId;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String emailUsuario;
    private String passwordUsuario;
    private int edadUsuario;
    private Long rolId;
    private String tipoRol;

}
