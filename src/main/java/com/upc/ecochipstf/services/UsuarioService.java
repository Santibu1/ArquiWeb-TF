package com.upc.ecochipstf.services;

import com.upc.ecochipstf.dto.UsuarioDTO;
import com.upc.ecochipstf.entities.Rol;
import com.upc.ecochipstf.entities.Usuario;
import com.upc.ecochipstf.interfaces.IUsuarioService;
import com.upc.ecochipstf.repositorios.RolRepository;
import com.upc.ecochipstf.repositorios.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RolRepository rolRepository;

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        // BUSCAR Y ASIGNAR EL ROL COMPLETO
        if (usuarioDTO.getRolId() != null) {
            Rol rol = rolRepository.findById(usuarioDTO.getRolId())
                    .orElseThrow(() -> new RuntimeException("Rol con ID " + usuarioDTO.getRolId() + " no encontrado"));
            usuario.setRol(rol);
        } else {
            throw new RuntimeException("Debe asignar un rol al usuario");
        }

        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return modelMapper.map(usuarioGuardado, UsuarioDTO.class);
    }
    @Transactional
    @Override
    public void eliminarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        }
    }
    @Transactional
    @Override
    public UsuarioDTO modificarUsuario(UsuarioDTO usuarioDTO) {

        return usuarioRepository.findById(usuarioDTO.getUsuarioId())
                .map(existingUsuario -> {

                    Optional.ofNullable(usuarioDTO.getNombreUsuario()).ifPresent(existingUsuario::setNombreUsuario);
                    Optional.ofNullable(usuarioDTO.getApellidoUsuario()).ifPresent(existingUsuario::setApellidoUsuario);
                    Optional.ofNullable(usuarioDTO.getEmailUsuario()).ifPresent(existingUsuario::setEmailUsuario);
                    Optional.ofNullable(usuarioDTO.getPasswordUsuario()).ifPresent(existingUsuario::setPasswordUsuario);

                    if (usuarioDTO.getEdadUsuario() > 0) {
                        existingUsuario.setEdadUsuario(usuarioDTO.getEdadUsuario());
                    }

                    if (usuarioDTO.getRolId() != null) {
                        Rol nuevoRol = rolRepository.findById(usuarioDTO.getRolId())
                                .orElseThrow(() -> new RuntimeException("Rol con ID " + usuarioDTO.getRolId() + " no encontrado"));
                        existingUsuario.setRol(nuevoRol); }
                    Usuario updatedUsuario = usuarioRepository.save(existingUsuario);
                    UsuarioDTO responseDTO = new UsuarioDTO(); modelMapper.map(updatedUsuario, responseDTO);
                    if (updatedUsuario.getRol() != null) { responseDTO.setRolId(updatedUsuario.getRol().getRolId());
                        responseDTO.setTipoRol(updatedUsuario.getRol().getTipoRol()); } return responseDTO; })
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> {
                    // Crear DTO y mapear datos básicos
                    UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);

                    // Pobrar manualmente los campos del rol
                    if (usuario.getRol() != null) {
                        usuarioDTO.setRolId(usuario.getRol().getRolId());
                        usuarioDTO.setTipoRol(usuario.getRol().getTipoRol());
                    }

                    return usuarioDTO;
                })
                .toList();
    }
    @Override
    public UsuarioDTO listarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
                .orElseThrow(()-> new RuntimeException("Usuario con ID " + id + " no encontrado"));
    }

}
