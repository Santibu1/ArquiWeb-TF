package com.upc.ecochipstf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComunidadRequestDTO {
    private String nombre;
    private String descripcion;
    private Long solicitudId;
}
