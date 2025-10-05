package com.upc.ecochipstf.controllers;

import com.upc.ecochipstf.dto.ComunidadDTO;
import com.upc.ecochipstf.dto.MiembroDTO;
import com.upc.ecochipstf.interfaces.IComunidadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comunidades")
public class ComunidadController {

    @Autowired
    private IComunidadService comunidadService;

    @PostMapping("/crear")
    public ResponseEntity<ComunidadDTO> crearComunidad(@Valid @RequestBody ComunidadDTO comunidadDTO) {
        ComunidadDTO creada = comunidadService.crearComunidad(comunidadDTO);
        return ResponseEntity.ok(creada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComunidadDTO> obtenerPorId(@PathVariable Long id) {
        ComunidadDTO comunidad = comunidadService.obtenerComunidadPorId(id);
        return ResponseEntity.ok(comunidad);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ComunidadDTO>> listarComunidades() {
        List<ComunidadDTO> lista = comunidadService.listarComunidades();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ComunidadDTO> actualizarComunidad(@RequestBody ComunidadDTO comunidadDTO) {
        ComunidadDTO actualizada = comunidadService.actualizarComunidad(comunidadDTO);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComunidad(@PathVariable Long id) {
        comunidadService.eliminarComunidad(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/unir")
    public ResponseEntity<MiembroDTO> unirUsuario(@RequestBody MiembroDTO dto) {
        MiembroDTO respuesta = comunidadService.unirUsuarioAComunidad(dto);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<MiembroDTO>> listarComunidadesPorUsuario(@PathVariable Long usuarioId) {
        List<MiembroDTO> comunidades = comunidadService.listarComunidadesPorUsuario(usuarioId);
        return ResponseEntity.ok(comunidades);
    }
}
