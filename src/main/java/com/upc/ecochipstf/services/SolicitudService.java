package com.upc.ecochipstf.services;

import com.upc.ecochipstf.dto.SolicitudRequestDTO;
import com.upc.ecochipstf.dto.SolicitudResponseDTO;
import com.upc.ecochipstf.entities.Solicitud;
import com.upc.ecochipstf.entities.Usuario;
import com.upc.ecochipstf.interfaces.ISolicitudService;
import com.upc.ecochipstf.repositorios.SolicitudRepository;
import com.upc.ecochipstf.repositorios.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitudService implements ISolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public SolicitudResponseDTO crearSolicitud(SolicitudRequestDTO solicitudDTO) {
        Usuario moderador = usuarioRepository.findById(solicitudDTO.getModeradorId())
                .orElseThrow(() -> new RuntimeException("Moderador no encontrado"));

        Solicitud solicitud = new Solicitud();
        solicitud.setDescripcion(solicitudDTO.getDescripcion());
        solicitud.setEstado("PENDIENTE");
        solicitud.setFechaCreacion(LocalDate.now());
        solicitud.setModerador(moderador);

        Solicitud guardada = solicitudRepository.save(solicitud);
        return modelMapper.map(guardada, SolicitudResponseDTO.class);
    }

    @Override
    @Transactional
    public SolicitudResponseDTO aprobarSolicitud(Long solicitudId, Long adminId) {
        Solicitud solicitud = solicitudRepository.findById(solicitudId)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        Usuario admin = usuarioRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Administrador no encontrado"));

        solicitud.setEstado("APROBADA");
        solicitud.setAdministrador(admin);
        solicitud.setFechaRevision(LocalDate.now());

        Solicitud guardada = solicitudRepository.save(solicitud);
        return modelMapper.map(guardada, SolicitudResponseDTO.class);
    }

    @Override
    @Transactional
    public SolicitudResponseDTO rechazarSolicitud(Long solicitudId, Long adminId) {
        Solicitud solicitud = solicitudRepository.findById(solicitudId)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        Usuario admin = usuarioRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Administrador no encontrado"));

        solicitud.setEstado("RECHAZADA");
        solicitud.setAdministrador(admin);
        solicitud.setFechaRevision(LocalDate.now());

        Solicitud guardada = solicitudRepository.save(solicitud);
        return modelMapper.map(guardada, SolicitudResponseDTO.class);
    }

    @Override
    public List<SolicitudResponseDTO> listarSolicitudes() {
        return solicitudRepository.findAll()
                .stream()
                .map(s -> modelMapper.map(s, SolicitudResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SolicitudResponseDTO obtenerSolicitudPorId(Long id) {
        Solicitud solicitud = solicitudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        return modelMapper.map(solicitud, SolicitudResponseDTO.class);
    }
}
