package com.upc.ecochipstf.repositorios;

import com.upc.ecochipstf.entities.Comunidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComunidadRepository extends JpaRepository<Comunidad, Long> {
    List<Comunidad> findByEstado(String estado);
    List<Comunidad> findByNombreContainingIgnoreCase(String nombre);
}
