package com.upc.ecochipstf.controllers;

import com.upc.ecochipstf.dto.UsuarioProductoResponseDTO;
import com.upc.ecochipstf.dto.UsuarioProductoRequestDTO;
import com.upc.ecochipstf.interfaces.IUsuarioProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario-producto")
public class UsuarioProductoController {
    @Autowired
    private IUsuarioProductoService usuarioProductoService;

    @PostMapping("/canjear")
    public ResponseEntity<UsuarioProductoResponseDTO> canjear(@RequestBody UsuarioProductoRequestDTO requestDTO) {
        UsuarioProductoResponseDTO respuesta = usuarioProductoService.canjear(requestDTO);
        return ResponseEntity.ok(respuesta);
    }
    @GetMapping("/historial/{usuarioId}")
    public ResponseEntity<List<UsuarioProductoResponseDTO>> listar(@PathVariable Long usuarioId) {
        List<UsuarioProductoResponseDTO> historial = usuarioProductoService.historial(usuarioId);
        return ResponseEntity.ok(historial);
    }

}
