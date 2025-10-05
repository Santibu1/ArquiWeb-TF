package com.upc.ecochipstf.repositorios;
import com.upc.ecochipstf.entities.Empresa;
import com.upc.ecochipstf.entities.Usuario;

import com.upc.ecochipstf.dto.MetricasEmpresaDTO;
import com.upc.ecochipstf.dto.ReporteEmpresaDTO;
import com.upc.ecochipstf.entities.UsuarioProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioProductoRepository extends JpaRepository<UsuarioProducto, Long> {
    List<UsuarioProducto> findByUsuarioUsuarioIdOrderByFechaCanjeDesc(Long usuarioId);
    // 🔹 Ranking de empresas por cantidad de productos reclamados
    @Query("SELECT new com.upc.ecochipstf.dto.ReporteEmpresaDTO(" +
            "p.empresa.empresaId, " +
            "p.empresa.nombre, " +
            "COUNT(up.id)) " +
            "FROM UsuarioProducto up " +
            "JOIN up.producto p " +
            "WHERE up.estado = 'Completado' " +
            "GROUP BY p.empresa.empresaId, p.empresa.nombre " +
            "ORDER BY COUNT(up.id) DESC")
    List<ReporteEmpresaDTO> obtenerRankingEmpresasReclamadas();

    // 🔹 Detalle de métricas por empresa
    @Query("SELECT new com.upc.ecochipstf.dto.MetricasEmpresaDTO(" +
            "p.nombre, COUNT(up.id), SUM(up.ecobitsUtilizados)) " +
            "FROM UsuarioProducto up " +
            "JOIN up.producto p " +
            "WHERE p.empresa.empresaId = :empresaId " +
            "GROUP BY p.nombre " +
            "ORDER BY COUNT(up.id) DESC")
    List<MetricasEmpresaDTO> obtenerMetricasPorEmpresa(Long empresaId);
}
