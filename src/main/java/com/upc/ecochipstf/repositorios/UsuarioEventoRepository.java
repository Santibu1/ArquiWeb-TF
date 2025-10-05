package com.upc.ecochipstf.repositorios;

import com.upc.ecochipstf.entities.UsuarioEvento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioEventoRepository extends JpaRepository<UsuarioEvento, Long> {
    public List<UsuarioEvento> findByUsuarioUsuarioId(Long usuarioId);
    public List<UsuarioEvento> findByEventoEventoId(Long eventoId);
    public Optional<UsuarioEvento> findByUsuarioUsuarioIdAndEventoEventoId(Long usuarioId, Long eventoId);
}//