package com.upc.ecochipstf.dto;

import com.upc.ecochipstf.entities.Usuario;
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
public class ActividadDTO {
    private Long actividadId;
    @NotNull(message = "La actividad no puede ser nula")
    @Size(min = 2, max = 50, message = "El nombre de la actividad debe tener entre 2 y 50 caracteres")
    private String nombreActividad;
    @NotNull(message = "La descripción no puede ser nula")
    @Size(min = 2, max = 50, message = "La descripción debe tener entre 2 y 50 caracteres")
    private String descripcionActividad;
    private Integer recompensaActividad;
    private String categoriaActividad;
    private String estadoActividad;
    private Long usuarioId;

}
