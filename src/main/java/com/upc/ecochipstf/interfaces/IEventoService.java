package com.upc.ecochipstf.interfaces;

import com.upc.ecochipstf.dto.EventoDTO;

import java.util.List;

public interface IEventoService {
    public EventoDTO registrarEvento(EventoDTO eventoDTO);
    public List<EventoDTO> listarEventosPorComunidad(Long comunidadId);
}
