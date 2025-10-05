package com.upc.ecochipstf.controllers;

import com.upc.ecochipstf.dto.UsuarioEventoDTO;
import com.upc.ecochipstf.interfaces.IUsuarioEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario-eventos")
public class UsuarioEventoController {

    @Autowired
    private IUsuarioEventoService usuarioEventoService;

    @PostMapping("/inscribirse/{usuarioId}/{eventoId}")
    public UsuarioEventoDTO inscribirse(@PathVariable Long usuarioId, @PathVariable Long eventoId) {
        return usuarioEventoService.inscribirseEnEvento(usuarioId, eventoId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<UsuarioEventoDTO> listarEventosPorUsuario(@PathVariable Long usuarioId) {
        return usuarioEventoService.listarEventosPorUsuario(usuarioId);
    }

    @DeleteMapping("/cancelar/{usuarioId}/{eventoId}")
    public void cancelar(@PathVariable Long usuarioId, @PathVariable Long eventoId) {
        usuarioEventoService.cancelarInscripcion(usuarioId, eventoId);
    }
}

