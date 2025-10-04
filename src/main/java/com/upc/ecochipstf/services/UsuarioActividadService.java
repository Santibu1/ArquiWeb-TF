package com.upc.ecochipstf.services;

import com.upc.ecochipstf.dto.UsuarioActividadDTO;
import com.upc.ecochipstf.entities.Actividad;
import com.upc.ecochipstf.entities.Usuario;
import com.upc.ecochipstf.entities.UsuarioActividad;
import com.upc.ecochipstf.interfaces.IUsuarioActividadService;
import com.upc.ecochipstf.repositorios.ActividadRepository;
import com.upc.ecochipstf.repositorios.UsuarioActividadRepository;
import com.upc.ecochipstf.repositorios.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioActividadService implements IUsuarioActividadService {
    @Autowired
    private UsuarioActividadRepository usuarioActividadRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ActividadRepository actividadRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public UsuarioActividadDTO completarActividad(Long actividadId, Long usuarioId) {
        Actividad actividad = actividadRepository.findById(actividadId)
                .orElseThrow(() -> new RuntimeException("Actividad con ID " + actividadId + " no encontrada"));

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario con ID " + usuarioId + " no encontrado"));

        if (!"Activa".equalsIgnoreCase(actividad.getEstadoActividad())) {
            throw new RuntimeException("La actividad no está activa.");
        }

        // Crear relación
        UsuarioActividad usuarioActividad = new UsuarioActividad();
        usuarioActividad.setUsuario(usuario);
        usuarioActividad.setActividad(actividad);
        usuarioActividad.setEstado("Completada");
        usuarioActividad.setFechaCompletado(LocalDate.now());
        usuarioActividadRepository.save(usuarioActividad);

        // Recompensa base
        int recompensa = actividad.getRecompensaActividad();

        // Verificar si el usuario tiene plan
        if (usuario.getPlan() != null) {
            Double porcentajeExtra = usuario.getPlan().getPorcentajeExtra(); // Ej: 0.10 (10%)
            if (porcentajeExtra != null && porcentajeExtra > 0) {
                int extra = (int) Math.round(recompensa * porcentajeExtra);
                recompensa += extra;
            }
        }

        // Sumar ecoBits al usuario
        Long ecoBitsActuales = usuario.getEcobits() == null ? 0L : usuario.getEcobits();
        usuario.setEcobits(ecoBitsActuales + recompensa);
        usuarioRepository.save(usuario);

        return modelMapper.map(usuarioActividad, UsuarioActividadDTO.class);
    }

    @Override
    public List<UsuarioActividadDTO> listarActividadesPorUsuario(Long usuarioId) {
        return usuarioActividadRepository.findByUsuarioUsuarioId(usuarioId)
                .stream()
                .map(ua -> modelMapper.map(ua, UsuarioActividadDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioActividadDTO> listarUsuariosPorActividad(Long actividadId) {
        return usuarioActividadRepository.findByActividadActividadId(actividadId)
                .stream()
                .map(ua -> modelMapper.map(ua, UsuarioActividadDTO.class))
                .collect(Collectors.toList());
    }
}
