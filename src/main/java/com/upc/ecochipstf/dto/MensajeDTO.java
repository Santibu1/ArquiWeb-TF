package com.upc.ecochipstf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MensajeDTO {
    private Long mensajeId;
    private String contenido;
    private LocalDateTime fechaEnvio;
    private Long usuarioId;
    private Long comunidadId;
    private String usuarioNombre;
}
