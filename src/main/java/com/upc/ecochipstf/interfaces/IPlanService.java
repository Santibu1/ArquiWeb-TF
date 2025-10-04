package com.upc.ecochipstf.interfaces;

import com.upc.ecochipstf.dto.PlanDTO;

import java.util.List;

public interface IPlanService {
    public PlanDTO crearPlan(PlanDTO planDTO);
    public List<PlanDTO> listarPlanesActivos();
    public PlanDTO obtenerPlanPorId(Long id);
    public PlanDTO actualizarPlan(PlanDTO planDTO);
    public void eliminarPlan(Long id);

}
