package com.upc.ecochipstf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudDTO {
    private Long idSolicitud;
    private Long idModerador;
    private Long idAdministrador;
    private String nombreComunidad;
    private String ubicacion;
    private String descripcion;
    private String estado;
    private LocalDate fechaCreacion;
    private LocalDate fechaRevision;
}
