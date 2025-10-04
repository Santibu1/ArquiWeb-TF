package com.upc.ecochipstf.repositorios;

import com.upc.ecochipstf.entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findByEstado(String estado);
}
