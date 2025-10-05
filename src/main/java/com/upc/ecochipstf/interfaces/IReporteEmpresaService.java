package com.upc.ecochipstf.interfaces;

import com.upc.ecochipstf.dto.MetricasEmpresaDTO;
import com.upc.ecochipstf.dto.ReporteEmpresaDTO;

import java.util.List;

public interface IReporteEmpresaService {
    List<ReporteEmpresaDTO> obtenerRankingEmpresas();
    List<MetricasEmpresaDTO> obtenerMetricas(Long empresaId);
}
