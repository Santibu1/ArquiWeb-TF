package com.upc.ecochipstf.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReporteParticipacionDTO {
    private Long usuarioId;
    private int mes;
    private int anio;
    private int totalEventos;
    private int totalPuntos;
    private List<String> nombresEventos;
}
