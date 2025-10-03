package com.upc.ecochipstf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO {
    private Long empresaId;
    private String nombre;
    private String categoria;
    private String descripcion;
    private String estado;
    private Long usuarioId;
}
