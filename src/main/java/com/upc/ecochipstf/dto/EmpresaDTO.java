package com.upc.ecochipstf.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull(message = "El nombre de la empresa no puede ser nula")
    @Size(min = 2, max = 50, message = "El nombre de la empresa debe tener entre 2 y 50 caracteres")
    private String nombre;
    private String categoria;
    private String descripcion;
    private String estado;
    private Long usuarioId;///
}
