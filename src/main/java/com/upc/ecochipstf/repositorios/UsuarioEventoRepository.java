package com.upc.ecochipstf.repositorios;

import com.upc.ecochipstf.entities.UsuarioEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioEventoRepository extends JpaRepository<UsuarioEvento, Long> {
    public List<UsuarioEvento> findByUsuarioUsuarioId(Long usuarioId);
    public List<UsuarioEvento> findByEventoEventoId(Long eventoId);
    public Optional<UsuarioEvento> findByUsuarioUsuarioIdAndEventoEventoId(Long usuarioId, Long eventoId);
    @Query(value = "SELECT ue.* FROM usuario_evento ue " +
            "JOIN evento e ON e.evento_id = ue.id_evento " +
            "WHERE ue.id_usuario = :usuarioId " +
            "AND EXTRACT(MONTH FROM e.fecha) = :mes " +
            "AND EXTRACT(YEAR FROM e.fecha) = :anio", nativeQuery = true)
    List<UsuarioEvento> findParticipacionesMensuales(
            @Param("usuarioId") Long usuarioId,
            @Param("mes") int mes,
            @Param("anio") int anio);
}