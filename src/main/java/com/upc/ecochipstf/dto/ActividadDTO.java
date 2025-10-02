package com.upc.ecochipstf.dto;

import com.upc.ecochipstf.entities.Usuario;
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
    private String nombreActividad;
    private String descripcionActividad;
    private Integer recompensaActividad;
    private String categoriaActividad;
    private String estadoActividad;
    private Long usuarioId;

}
