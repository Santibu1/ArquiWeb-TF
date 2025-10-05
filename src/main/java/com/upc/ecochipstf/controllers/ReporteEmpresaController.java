package com.upc.ecochipstf.controllers;

import com.upc.ecochipstf.dto.MetricasEmpresaDTO;
import com.upc.ecochipstf.dto.ReporteEmpresaDTO;
import com.upc.ecochipstf.interfaces.IReporteEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteEmpresaController {

    @Autowired
    private IReporteEmpresaService reporteEmpresaService;

    @GetMapping("/empresas")
    public List<ReporteEmpresaDTO> obtenerRankingEmpresas() {
        return reporteEmpresaService.obtenerRankingEmpresas();
    }

    @GetMapping("/empresas/{empresaId}")
    public List<MetricasEmpresaDTO> obtenerMetricas(@PathVariable Long empresaId) {
        return reporteEmpresaService.obtenerMetricas(empresaId);
    }
}
