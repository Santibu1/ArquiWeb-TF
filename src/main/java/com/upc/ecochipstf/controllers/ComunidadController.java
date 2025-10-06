package com.upc.ecochipstf.controllers;

import com.upc.ecochipstf.dto.ComunidadDTO;
import com.upc.ecochipstf.dto.MiembroDTO;
import com.upc.ecochipstf.interfaces.IComunidadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comunidades")
public class ComunidadController {

    @Autowired
    private IComunidadService comunidadService;

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PostMapping("/crear")
    public ResponseEntity<ComunidadDTO> crearComunidad(@Valid @RequestBody ComunidadDTO comunidadDTO) {
        ComunidadDTO creada = comunidadService.crearComunidad(comunidadDTO);
        return ResponseEntity.ok(creada);
    }

    @PreAuthorize("hasAnyRole('ADMINISTRADOR')")
    @GetMapping("/{id}")
    public ResponseEntity<ComunidadDTO> obtenerPorId(@PathVariable Long id) {
        ComunidadDTO comunidad = comunidadService.obtenerComunidadPorId(id);
        return ResponseEntity.ok(comunidad);
    }

    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'MODERADOR', 'CLIENTE')")
    @GetMapping("/listar")
    public ResponseEntity<List<ComunidadDTO>> listarComunidades() {
        List<ComunidadDTO> lista = comunidadService.listarComunidades();
        return ResponseEntity.ok(lista);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PutMapping("/actualizar")
    public ResponseEntity<ComunidadDTO> actualizarComunidad(@RequestBody ComunidadDTO comunidadDTO) {
        ComunidadDTO actualizada = comunidadService.actualizarComunidad(comunidadDTO);
        return ResponseEntity.ok(actualizada);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComunidad(@PathVariable Long id) {
        comunidadService.eliminarComunidad(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('MODERADOR','CLIENTE')")
    @PostMapping("/unir")
    public ResponseEntity<MiembroDTO> unirUsuario(@RequestBody MiembroDTO dto) {
        MiembroDTO respuesta = comunidadService.unirUsuarioAComunidad(dto);
        return ResponseEntity.ok(respuesta);
    }

    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'MODERADOR', 'CLIENTE')")
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<MiembroDTO>> listarComunidadesPorUsuario(@PathVariable Long usuarioId) {
        List<MiembroDTO> comunidades = comunidadService.listarComunidadesPorUsuario(usuarioId);
        return ResponseEntity.ok(comunidades);
    }
}
