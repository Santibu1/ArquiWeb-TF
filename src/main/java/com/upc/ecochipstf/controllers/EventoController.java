package com.upc.ecochipstf.controllers;

import com.upc.ecochipstf.dto.EventoDTO;
import com.upc.ecochipstf.interfaces.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {
    @Autowired
    private IEventoService eventoService;

    @PostMapping("/registrar")
    public EventoDTO registrarEvento(@RequestBody EventoDTO eventoDTO) {
        return eventoService.registrarEvento(eventoDTO);
    }

    @GetMapping("/comunidad/{comunidadId}")
    public List<EventoDTO> listarEventosPorComunidad(@PathVariable Long comunidadId) {
        return eventoService.listarEventosPorComunidad(comunidadId);
    }
}//