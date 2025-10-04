package com.upc.ecochipstf.controllers;
import com.upc.ecochipstf.dto.PlanDTO;
import com.upc.ecochipstf.interfaces.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlanController {
    @Autowired
    private IPlanService planService;

    @PostMapping("/Crear-Plan")
    public PlanDTO crearPlan(@RequestBody PlanDTO planDTO) {
        return planService.crearPlan(planDTO);
    }

    @GetMapping("/Listar-Planes-Activos")
    public List<PlanDTO> listarPlanesActivos() {
        return planService.listarPlanesActivos();
    }

    @GetMapping("/Listar-Planes-Por/{id}")
    public PlanDTO obtenerPlanPorId(@PathVariable Long id) {
        return planService.obtenerPlanPorId(id);
    }

    @PutMapping("/Actualizar-Plan")
    public PlanDTO actualizarPlan(@RequestBody PlanDTO planDTO) {
        return planService.actualizarPlan(planDTO);
    }

    @DeleteMapping("/Eliminar-Plan/{id}")
    public void eliminarPlan(@PathVariable Long id) {
        planService.eliminarPlan(id);
    }
}