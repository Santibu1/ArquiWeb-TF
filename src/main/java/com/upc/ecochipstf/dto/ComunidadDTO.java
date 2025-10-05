package com.upc.ecochipstf.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull(message = "El nombre de la comunidad no puede ser nula")
    @Size(min = 2, max = 50, message = "El nombre de la comunidad debe tener entre 2 y 50 caracteres")
    private String nombre;
    private String ubicacion;
    private String descripcion;
    private String estado;
    private List<Long> miembrosIds;//
}
