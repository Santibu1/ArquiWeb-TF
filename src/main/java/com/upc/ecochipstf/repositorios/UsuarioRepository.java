package com.upc.ecochipstf.repositorios;

import com.upc.ecochipstf.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
    @Override
    List<Usuario> findAll();
}
