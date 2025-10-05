package com.upc.ecochipstf.repositorios;

import com.upc.ecochipstf.entities.UsuarioProducto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioProductoRepository extends JpaRepository<UsuarioProducto, Long> {
    List<UsuarioProducto> findByUsuarioUsuarioIdOrderByFechaCanjeDesc(Long usuarioId);
}
