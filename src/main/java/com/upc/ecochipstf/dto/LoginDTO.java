package com.upc.ecochipstf.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    @Email(message = "El email debe ser válido")
    private String email;
    private String password;
    private String mensaje;
    private Long usuarioId;
    private String nombreCompleto;
    private String rol;
    private String token;
}
