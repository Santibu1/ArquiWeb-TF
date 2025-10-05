package com.upc.ecochipstf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComunidadDTO {
    private Long idComunidad;
    private Long idSolicitud;
    private Long idModerador;
    private String nombre;
    private String ubicacion;
    private String descripcion;
    private String estado;
    private List<Long> miembrosIds;//
}
