package com.upc.ecochipstf.repositorios;

import com.upc.ecochipstf.entities.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActividadRepository extends JpaRepository<Actividad,Long> {
    List<Actividad> findByEstadoActividad(String estadoActividad);
}
