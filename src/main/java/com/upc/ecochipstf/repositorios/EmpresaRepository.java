package com.upc.ecochipstf.repositorios;

import com.upc.ecochipstf.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    List<Empresa> findByEstado(String estado);
}
