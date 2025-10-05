package com.upc.ecochipstf.services;

import com.upc.ecochipstf.dto.SolicitudDTO;
import com.upc.ecochipstf.entities.Comunidad;
import com.upc.ecochipstf.entities.Solicitud;
import com.upc.ecochipstf.entities.Usuario;
import com.upc.ecochipstf.interfaces.ISolicitudService;
import com.upc.ecochipstf.repositorios.ComunidadRepository;
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
    private ComunidadRepository comunidadRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public SolicitudDTO crearSolicitud(SolicitudDTO solicitudDTO) {
        Solicitud solicitud = modelMapper.map(solicitudDTO, Solicitud.class);
        solicitud.setFechaCreacion(LocalDate.now());
        solicitud.setEstado("Pendiente");

        // Verifica el moderador
        Usuario moderador = usuarioRepository.findById(solicitudDTO.getIdModerador())
                .orElseThrow(() -> new RuntimeException("Moderador no encontrado"));
        solicitud.setModerador(moderador);

        solicitud = solicitudRepository.save(solicitud);
        return modelMapper.map(solicitud, SolicitudDTO.class);
    }

    @Override
    @Transactional
    public SolicitudDTO aprobarSolicitud(Long solicitudId, Long adminId) {
        Solicitud solicitud = solicitudRepository.findById(solicitudId)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        Usuario admin = usuarioRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Administrador no encontrado"));

        solicitud.setAdministrador(admin);
        solicitud.setFechaRevision(LocalDate.now());
        solicitud.setEstado("Aprobada");
        solicitudRepository.save(solicitud);

        Comunidad comunidad = new Comunidad();
        comunidad.setNombre(solicitud.getNombreComunidad());
        comunidad.setDescripcion(solicitud.getDescripcion());
        comunidad.setUbicacion(solicitud.getUbicacion());
        comunidad.setEstado("Activa");
        comunidad.setSolicitud(solicitud);
        comunidad.setModerador(solicitud.getModerador());
        comunidadRepository.save(comunidad);

        return modelMapper.map(solicitud, SolicitudDTO.class);
    }

    @Override
    @Transactional
    public SolicitudDTO rechazarSolicitud(Long solicitudId, Long adminId) {
        Solicitud solicitud = solicitudRepository.findById(solicitudId)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        Usuario admin = usuarioRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Administrador no encontrado"));

        solicitud.setAdministrador(admin);
        solicitud.setFechaRevision(LocalDate.now());
        solicitud.setEstado("Rechazada");
        solicitudRepository.save(solicitud);

        return modelMapper.map(solicitud, SolicitudDTO.class);
    }

    @Override
    public List<SolicitudDTO> listarSolicitudes() {
        return solicitudRepository.findAll()
                .stream()
                .map(solicitud -> modelMapper.map(solicitud, SolicitudDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SolicitudDTO obtenerSolicitudPorId(Long id) {
        Solicitud solicitud = solicitudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        return modelMapper.map(solicitud, SolicitudDTO.class);
    }
}
