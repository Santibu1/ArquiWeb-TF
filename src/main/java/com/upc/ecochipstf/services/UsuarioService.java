package com.upc.ecochipstf.services;

import com.upc.ecochipstf.dto.UsuarioDTO;
import com.upc.ecochipstf.entities.Usuario;
import com.upc.ecochipstf.interfaces.IUsuarioService;
import com.upc.ecochipstf.repositorios.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        return modelMapper.map(usuarioRepository.save(usuario), UsuarioDTO.class);
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
                    // 1. Actualizar la ENTITY existente con los datos del DTO
                    modelMapper.map(usuarioDTO, existingUsuario); // ← Mapear SOBRE la entity

                    // 2. Guardar la ENTITY actualizada
                    Usuario updatedUsuario = usuarioRepository.save(existingUsuario);

                    // 3. Convertir la ENTITY guardada de vuelta a DTO
                    return modelMapper.map(updatedUsuario, UsuarioDTO.class);
                }).orElseThrow(() -> new RuntimeException("Usuario con ID " + usuarioDTO.getUsuarioId() + " no encontrado"));
    }
    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
                .toList();
    }
    @Override
    public UsuarioDTO listarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
                .orElseThrow(()-> new RuntimeException("Usuario con ID " + id + " no encontrado"));
    }

}
