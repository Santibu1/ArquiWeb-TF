package com.upc.ecochipstf.repositorios;

import com.upc.ecochipstf.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByEstado(String estado);
    List<Producto> findByEmpresaEmpresaId(Long empresaId);
}
