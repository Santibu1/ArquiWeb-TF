package com.upc.ecochipstf.repositorios;

import com.upc.ecochipstf.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol,Long> {
    Optional<Rol> findById(Long id);
}
