package com.upc.ecochipstf.repositorios;
import com.upc.ecochipstf.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {
   public List<Evento> findByComunidadIdComunidad(Long idComunidad);


}
