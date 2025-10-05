package com.upc.ecochipstf.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO {
    private Long eventoId;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private LocalDate fecha;
    private String organizador;
    private String beneficios;
    private String recompensa;
    private String estado;
    private Long comunidadId;////
}
