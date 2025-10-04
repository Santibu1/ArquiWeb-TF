package com.upc.ecochipstf.repositorios;

import com.upc.ecochipstf.entities.UsuarioActividad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface UsuarioActividadRepository extends JpaRepository<UsuarioActividad, Long> {
    Collection<Object> findByUsuarioUsuarioId(Long usuarioUsuarioId);

    Collection<Object> findByActividadActividadId(Long actividadActividadId);
}
