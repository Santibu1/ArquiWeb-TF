package com.upc.ecochipstf.services;

import com.upc.ecochipstf.dto.PlanDTO;
import com.upc.ecochipstf.entities.Plan;
import com.upc.ecochipstf.interfaces.IPlanService;
import com.upc.ecochipstf.repositorios.PlanRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanService implements IPlanService {
    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PlanDTO crearPlan(PlanDTO planDTO) {
        Plan plan = modelMapper.map(planDTO, Plan.class);
        plan.setEstado("Activo");
        plan = planRepository.save(plan);
        return modelMapper.map(plan, PlanDTO.class);
    }

    @Override
    public List<PlanDTO> listarPlanesActivos() {
        return planRepository.findByEstado("Activo")
                .stream()
                .map(plan -> modelMapper.map(plan, PlanDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PlanDTO obtenerPlanPorId(Long id) {
        return planRepository.findById(id)
                .map(plan -> modelMapper.map(plan, PlanDTO.class))
                .orElseThrow(() -> new RuntimeException("Plan con ID " + id + " no encontrado"));
    }

    @Override
    public PlanDTO actualizarPlan(PlanDTO planDTO) {
        return planRepository.findById(planDTO.getPlanId())
                .map(existing -> {
                    Plan plan = modelMapper.map(planDTO, Plan.class);
                    Plan actualizado = planRepository.save(plan);
                    return modelMapper.map(actualizado, PlanDTO.class);
                })
                .orElseThrow(() -> new RuntimeException("Plan con ID " + planDTO.getPlanId() + " no encontrado"));
    }

    @Override
    public void eliminarPlan(Long id) {
        planRepository.findById(id).ifPresent(plan -> {
            plan.setEstado("Inactivo");
            planRepository.save(plan);
        });
    }
}