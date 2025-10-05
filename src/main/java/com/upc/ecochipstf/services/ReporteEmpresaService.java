package com.upc.ecochipstf.services;

import com.upc.ecochipstf.dto.MetricasEmpresaDTO;
import com.upc.ecochipstf.dto.ReporteEmpresaDTO;
import com.upc.ecochipstf.entities.Empresa;
import com.upc.ecochipstf.entities.UsuarioProducto;
import com.upc.ecochipstf.interfaces.IReporteEmpresaService;
import com.upc.ecochipstf.repositorios.UsuarioProductoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteEmpresaService implements IReporteEmpresaService {

    @Autowired
    private UsuarioProductoRepository usuarioProductoRepository;

    @Override
    @Transactional
    public List<ReporteEmpresaDTO> obtenerRankingEmpresas() {
        return usuarioProductoRepository.obtenerRankingEmpresasReclamadas();
    }

    @Override
    @Transactional
    public List<MetricasEmpresaDTO> obtenerMetricas(Long empresaId) {
        return usuarioProductoRepository.obtenerMetricasPorEmpresa(empresaId);
    }
}