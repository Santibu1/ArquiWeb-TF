package com.upc.ecochipstf.controllers;

import com.upc.ecochipstf.dto.ComunidadRequestDTO;
import com.upc.ecochipstf.dto.ComunidadResponseDTO;
import com.upc.ecochipstf.interfaces.IComunidadService;
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
    public ResponseEntity<ComunidadResponseDTO> crearComunidad(@RequestBody ComunidadRequestDTO dto) {
        ComunidadResponseDTO creada = comunidadService.crearComunidad(dto);
        return ResponseEntity.ok(creada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComunidadResponseDTO> obtenerComunidad(@PathVariable Long id) {
        ComunidadResponseDTO comunidad = comunidadService.obtenerComunidadPorId(id);
        return ResponseEntity.ok(comunidad);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ComunidadResponseDTO>> listarComunidades() {
        List<ComunidadResponseDTO> lista = comunidadService.listarComunidades();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<ComunidadResponseDTO> actualizarComunidad(
            @PathVariable Long id,
            @RequestBody ComunidadRequestDTO dto) {
        ComunidadResponseDTO actualizada = comunidadService.actualizarComunidad(dto);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarComunidad(@PathVariable Long id) {
        comunidadService.eliminarComunidad(id);
        return ResponseEntity.noContent().build();
    }
}
