package com.upc.ecochipstf.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReporteEmpresaDTO {
    private Long empresaId;
    private String nombreEmpresa;
    private Long cantidadReclamos;
}
