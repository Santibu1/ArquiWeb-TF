package com.upc.ecochipstf.controllers;

import com.upc.ecochipstf.dto.ActividadDTO;
import com.upc.ecochipstf.interfaces.IActividadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ActividadController {
    @Autowired
    private IActividadService actividadService;

    // Crear actividad (solo Admin)
    @PostMapping("/registrarActividad")
    public ResponseEntity<ActividadDTO> crearActividad(@Valid @RequestBody ActividadDTO actividadDTO) {
        return ResponseEntity.ok(actividadService.crearActividad(actividadDTO));
    }

    // Listar todas las actividades activas
    @GetMapping("/listarActividades")
    public ResponseEntity<List<ActividadDTO>> listarActividadesActivas() {
        return ResponseEntity.ok(actividadService.listarActividadesActivas());
    }

    // Obtener actividad por ID
    @GetMapping("/listarActividadesPorID/{id}")
    public ResponseEntity<ActividadDTO> obtenerActividadPorId(@PathVariable Long id) {
        return ResponseEntity.ok(actividadService.obtenerActividadPorId(id));
    }

    // Actualizar actividad
    @PutMapping("/actualizarActividades/{id}")
    public ResponseEntity<ActividadDTO> actualizarActividad(@PathVariable Long id, @RequestBody ActividadDTO actividadDTO) {
        actividadDTO.setActividadId(id);
        return ResponseEntity.ok(actividadService.actualizarActividad(actividadDTO));
    }

    // Eliminar (baja lógica)
    @DeleteMapping("/eliminar-Actividad/{id}")
    public ResponseEntity<Void> eliminarActividad(@PathVariable Long id) {
        actividadService.eliminarActividad(id);
        return ResponseEntity.noContent().build();
    }
}
