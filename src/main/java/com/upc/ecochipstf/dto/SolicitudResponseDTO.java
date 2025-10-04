package com.upc.ecochipstf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudResponseDTO {
    private Long solicitudId;
    private String descripcion;
    private String estado;
    private String fechaCreacion;
    private String fechaRevision;

    private String moderadorNombre;
    private String administradorNombre;
}
