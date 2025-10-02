package com.upc.ecochipstf.controllers;
import com.upc.ecochipstf.dto.UsuarioActividadDTO;
import com.upc.ecochipstf.interfaces.IUsuarioActividadService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/usuario-actividad")
public class UsuarioActividadController {
    @Autowired
    private IUsuarioActividadService usuarioActividadService;

    @PostMapping("/completar/{usuarioId}/{actividadId}")
    public UsuarioActividadDTO completarActividad(@PathVariable Long usuarioId, @PathVariable Long actividadId) {
        return usuarioActividadService.completarActividad(actividadId, usuarioId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<UsuarioActividadDTO> listarPorUsuario(@PathVariable Long usuarioId) {
        return usuarioActividadService.listarActividadesPorUsuario(usuarioId);
    }

    @GetMapping("/actividad/{actividadId}")
    public List<UsuarioActividadDTO> listarPorActividad(@PathVariable Long actividadId) {
        return usuarioActividadService.listarUsuariosPorActividad(actividadId);
    }
}
