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
public class ComunidadResponseDTO {
    private Long comunidadId;
    private String nombre;
    private String descripcion;
    private String estado;

    private Long solicitudId;
    private List<String> miembros;
}
