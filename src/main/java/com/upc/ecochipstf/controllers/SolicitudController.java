package com.upc.ecochipstf.controllers;

import com.upc.ecochipstf.dto.SolicitudDTO;
import com.upc.ecochipstf.interfaces.ISolicitudService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    @Autowired
    private ISolicitudService solicitudService;

    @PostMapping("/crear")
    public ResponseEntity<SolicitudDTO> crearSolicitud(@Valid @RequestBody SolicitudDTO solicitudDTO) {
        SolicitudDTO creada = solicitudService.crearSolicitud(solicitudDTO);
        return ResponseEntity.ok(creada);
    }

    @PutMapping("/{id}/aprobar/{adminId}")
    public ResponseEntity<SolicitudDTO> aprobarSolicitud(@PathVariable Long id, @PathVariable Long adminId) {
        SolicitudDTO aprobada = solicitudService.aprobarSolicitud(id, adminId);
        return ResponseEntity.ok(aprobada);
    }

    @PutMapping("/{id}/rechazar/{adminId}")
    public ResponseEntity<SolicitudDTO> rechazarSolicitud(@PathVariable Long id, @PathVariable Long adminId) {
        SolicitudDTO rechazada = solicitudService.rechazarSolicitud(id, adminId);
        return ResponseEntity.ok(rechazada);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<SolicitudDTO>> listarSolicitudes() {
        List<SolicitudDTO> lista = solicitudService.listarSolicitudes();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudDTO> obtenerPorId(@PathVariable Long id) {
        SolicitudDTO solicitud = solicitudService.obtenerSolicitudPorId(id);
        return ResponseEntity.ok(solicitud);
    }
}
