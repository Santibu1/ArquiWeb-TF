package com.upc.ecochipstf.repositorios;

import com.upc.ecochipstf.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByemailUsuario(String emailUsuario);
}
