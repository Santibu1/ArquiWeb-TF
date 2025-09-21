package com.upc.ecochipstf.repositorios;

import com.upc.ecochipstf.entities.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadRepository extends JpaRepository<Actividad,Long> {
}
