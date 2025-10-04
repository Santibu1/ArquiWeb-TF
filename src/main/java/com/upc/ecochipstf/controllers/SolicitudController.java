package com.upc.ecochipstf.controllers;

import com.upc.ecochipstf.dto.SolicitudRequestDTO;
import com.upc.ecochipstf.dto.SolicitudResponseDTO;
import com.upc.ecochipstf.interfaces.ISolicitudService;
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
    public ResponseEntity<SolicitudResponseDTO> crearSolicitud(@RequestBody SolicitudRequestDTO dto) {
        SolicitudResponseDTO creada = solicitudService.crearSolicitud(dto);
        return ResponseEntity.ok(creada);
    }

    @PutMapping("/{id}/aprobar/{adminId}")
    public ResponseEntity<SolicitudResponseDTO> aprobarSolicitud(@PathVariable Long id, @PathVariable Long adminId) {
        SolicitudResponseDTO aprobada = solicitudService.aprobarSolicitud(id, adminId);
        return ResponseEntity.ok(aprobada);
    }

    @PutMapping("/{id}/rechazar/{adminId}")
    public ResponseEntity<SolicitudResponseDTO> rechazarSolicitud(@PathVariable Long id, @PathVariable Long adminId) {
        SolicitudResponseDTO rechazada = solicitudService.rechazarSolicitud(id, adminId);
        return ResponseEntity.ok(rechazada);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<SolicitudResponseDTO>> listarSolicitudes() {
        List<SolicitudResponseDTO> lista = solicitudService.listarSolicitudes();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudResponseDTO> obtenerSolicitud(@PathVariable Long id) {
        SolicitudResponseDTO solicitud = solicitudService.obtenerSolicitudPorId(id);
        return ResponseEntity.ok(solicitud);
    }
}
