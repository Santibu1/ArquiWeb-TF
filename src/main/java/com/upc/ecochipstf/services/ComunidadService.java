package com.upc.ecochipstf.services;

import com.upc.ecochipstf.dto.ComunidadRequestDTO;
import com.upc.ecochipstf.dto.ComunidadResponseDTO;
import com.upc.ecochipstf.entities.Comunidad;
import com.upc.ecochipstf.entities.Solicitud;
import com.upc.ecochipstf.interfaces.IComunidadService;
import com.upc.ecochipstf.repositorios.ComunidadRepository;
import com.upc.ecochipstf.repositorios.SolicitudRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComunidadService implements IComunidadService {

    @Autowired
    private ComunidadRepository comunidadRepository;

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public ComunidadResponseDTO crearComunidad(ComunidadRequestDTO comunidadDTO) {
        Solicitud solicitud = solicitudRepository.findById(comunidadDTO.getSolicitudId())
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        if (!"APROBADA".equalsIgnoreCase(solicitud.getEstado())) {
            throw new RuntimeException("No se puede crear comunidad porque la solicitud no está aprobada.");
        }

        Comunidad comunidad = new Comunidad();
        comunidad.setNombre(comunidadDTO.getNombre());
        comunidad.setDescripcion(comunidadDTO.getDescripcion());
        comunidad.setEstado("ACTIVA");
        comunidad.setSolicitud(solicitud);

        Comunidad guardada = comunidadRepository.save(comunidad);
        return modelMapper.map(guardada, ComunidadResponseDTO.class);
    }

    @Override
    public ComunidadResponseDTO obtenerComunidadPorId(Long id) {
        Comunidad comunidad = comunidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comunidad no encontrada"));
        return modelMapper.map(comunidad, ComunidadResponseDTO.class);
    }

    @Override
    public List<ComunidadResponseDTO> listarComunidades() {
        return comunidadRepository.findAll()
                .stream()
                .map(c -> modelMapper.map(c, ComunidadResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ComunidadResponseDTO actualizarComunidad(ComunidadRequestDTO comunidadDTO) {
        Comunidad comunidad = comunidadRepository.findById(comunidadDTO.getSolicitudId())
                .orElseThrow(() -> new RuntimeException("Comunidad no encontrada"));

        comunidad.setNombre(comunidadDTO.getNombre());
        comunidad.setDescripcion(comunidadDTO.getDescripcion());

        Comunidad actualizada = comunidadRepository.save(comunidad);
        return modelMapper.map(actualizada, ComunidadResponseDTO.class);
    }

    @Override
    @Transactional
    public void eliminarComunidad(Long id) {
        comunidadRepository.deleteById(id);
    }
}
