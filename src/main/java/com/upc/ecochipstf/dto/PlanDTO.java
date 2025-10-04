package com.upc.ecochipstf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlanDTO {
    private Long planId;
    private String nombre;
    private Double costo;
    private Integer duracionDias;
    private Double porcentajeExtra;
    private String estado;
}
