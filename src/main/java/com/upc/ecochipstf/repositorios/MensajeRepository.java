package com.upc.ecochipstf.repositorios;

import com.upc.ecochipstf.entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
    public List<Mensaje> findByComunidad_IdComunidadOrderByFechaEnvioAsc(Long comunidadId);
}
