package com.upc.ecochipstf.interfaces;

import com.upc.ecochipstf.dto.LoginDTO;
import com.upc.ecochipstf.dto.UsuarioDTO;
import com.upc.ecochipstf.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO);
    public void eliminarUsuario(Long id);
    public UsuarioDTO modificarUsuario(UsuarioDTO usuarioDTO);
    public List<UsuarioDTO> listarUsuarios();
    public UsuarioDTO asignarPlan(Long usuarioId, Long planId);
    
    public LoginDTO login(LoginDTO loginDTO);
}
