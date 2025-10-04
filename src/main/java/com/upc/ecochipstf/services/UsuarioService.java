package com.upc.ecochipstf.services;

import com.upc.ecochipstf.dto.UsuarioDTO;
import com.upc.ecochipstf.entities.Plan;
import com.upc.ecochipstf.entities.Rol;
import com.upc.ecochipstf.entities.Usuario;
import com.upc.ecochipstf.interfaces.IUsuarioService;
import com.upc.ecochipstf.repositorios.PlanRepository;
import com.upc.ecochipstf.repositorios.RolRepository;
import com.upc.ecochipstf.repositorios.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PlanRepository planRepository;

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO){
        Usuario usuarioExistente = usuarioRepository.findByemailUsuario(usuarioDTO.getEmailUsuario());
        if (usuarioExistente != null) {
            if ("Desactivado".equalsIgnoreCase(usuarioExistente.getEstado())) {
                usuarioExistente.setEstado("Activo");
                usuarioExistente.setEcobits(0L);
                usuarioExistente.setNombreUsuario(usuarioDTO.getNombreUsuario());
                usuarioExistente.setApellidoUsuario(usuarioDTO.getApellidoUsuario());

                // Actualiza otros campos necesarios
                usuarioExistente = usuarioRepository.save(usuarioExistente);
                return modelMapper.map(usuarioExistente, UsuarioDTO.class);
            } else {
                throw new RuntimeException("El correo ya está registrado y activo.");
            }
        }
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuario.setEstado("Activo");
        usuario = usuarioRepository.save(usuario);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }
    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.findById(id).ifPresent(usuario -> {
            usuario.setEstado("Desactivado");
            usuarioRepository.save(usuario);
        });
    }

    @Override //si es que hay administrador se hara la lista
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO modificarUsuario(UsuarioDTO usuarioDTO) {
        return usuarioRepository.findById(usuarioDTO.getUsuarioId())
                .map(existing -> {
                    Usuario usuarioEntidad = modelMapper.map(usuarioDTO, Usuario.class);
                    Usuario guardado = usuarioRepository.save(usuarioEntidad);
                    return modelMapper.map(guardado, UsuarioDTO.class);
                })
                .orElseThrow(() -> new RuntimeException("Usuario con ID " + usuarioDTO.getUsuarioId() + " no encontrado"));
    }
    @Override
    public UsuarioDTO asignarPlan(Long usuarioId, Long planId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));

        if (usuario.getPlan() != null) {
            throw new RuntimeException("El usuario ya tiene un plan asignado. Debe cancelarlo o cambiarlo.");
        }

        usuario.setPlan(plan);
        Usuario actualizado = usuarioRepository.save(usuario);


        UsuarioDTO dto = modelMapper.map(actualizado, UsuarioDTO.class);
        dto.setPlanId(plan.getPlanId());
        return dto;
    }

}
