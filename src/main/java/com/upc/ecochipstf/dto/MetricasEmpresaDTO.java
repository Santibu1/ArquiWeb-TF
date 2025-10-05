package com.upc.ecochipstf.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MetricasEmpresaDTO {
    private String nombreProducto;
    private Long cantidadReclamos;
    private Long totalEcobits;
}