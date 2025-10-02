package com.upc.ecochipstf.services;

import com.upc.ecochipstf.config.ModelMapperConfig;
import com.upc.ecochipstf.dto.ActividadDTO;
import com.upc.ecochipstf.dto.UsuarioActividadDTO;
import com.upc.ecochipstf.entities.Actividad;
import com.upc.ecochipstf.entities.Usuario;
import com.upc.ecochipstf.entities.UsuarioActividad;
import com.upc.ecochipstf.interfaces.IActividadService;
import com.upc.ecochipstf.repositorios.ActividadRepository;
import com.upc.ecochipstf.repositorios.RolRepository;
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
public class ActividadService implements IActividadService {
    @Autowired
    private ActividadRepository actividadRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UsuarioActividadRepository usuarioActividadRepository;

    @Override
    public ActividadDTO crearActividad(ActividadDTO actividadDTO) {
        Actividad actividad = modelMapper.map(actividadDTO, Actividad.class);
        actividad.setEstadoActividad("Activa");  // Por defecto
        actividad = actividadRepository.save(actividad);
        return modelMapper.map(actividad, ActividadDTO.class);
    }

    @Override
    public List<ActividadDTO> listarActividadesActivas() {
        return actividadRepository.findByEstadoActividad("Activa")
                .stream()
                .map(act -> modelMapper.map(act, ActividadDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ActividadDTO obtenerActividadPorId(Long id) {
        return actividadRepository.findById(id)
                .map(act -> modelMapper.map(act, ActividadDTO.class))
                .orElseThrow(() -> new RuntimeException("Actividad con ID " + id + " no encontrada"));
    }

    @Override
    public ActividadDTO actualizarActividad(ActividadDTO actividadDTO) {
        return actividadRepository.findById(actividadDTO.getActividadId())
                .map(existing -> {
                    Actividad actividad = modelMapper.map(actividadDTO, Actividad.class);
                    Actividad guardado = actividadRepository.save(actividad);
                    return modelMapper.map(guardado, ActividadDTO.class);
                })
                .orElseThrow(() -> new RuntimeException("Actividad con ID " + actividadDTO.getActividadId() + " no encontrada"));
    }

    @Override
    public void eliminarActividad(Long id) {
        actividadRepository.findById(id).ifPresent(actividad -> {
            actividad.setEstadoActividad("Inactiva"); // baja lógica
            actividadRepository.save(actividad);
        });
    }

}
