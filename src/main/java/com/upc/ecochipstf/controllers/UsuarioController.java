package com.upc.ecochipstf.controllers;

import com.upc.ecochipstf.dto.UsuarioDTO;
import com.upc.ecochipstf.interfaces.IUsuarioService;
import com.upc.ecochipstf.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/registrarUsuario")
    public ResponseEntity<UsuarioDTO> registrar(@RequestBody UsuarioDTO dto) {
        UsuarioDTO registrado = usuarioService.registrarUsuario(dto);
        return ResponseEntity.ok(registrado);
    }

    @GetMapping("/listarUsuarios")
    public ResponseEntity<List<UsuarioDTO>> listar() {
        List<UsuarioDTO> lista = usuarioService.listarUsuarios();
        return ResponseEntity.ok(lista);
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/editarUsuario/{id}")
    public ResponseEntity<UsuarioDTO> editar(@RequestBody UsuarioDTO dto) {
        UsuarioDTO actualizado = usuarioService.modificarUsuario(dto);
        return ResponseEntity.ok(actualizado);
    }
    @PutMapping("/Asignar-Plan-Usuario/{usuarioId}/plan/{planId}")
    public ResponseEntity<UsuarioDTO> asignarPlan(
            @PathVariable Long usuarioId,
            @PathVariable Long planId) {
        UsuarioDTO actualizado = usuarioService.asignarPlan(usuarioId, planId);
        return ResponseEntity.ok(actualizado);
    }
}
