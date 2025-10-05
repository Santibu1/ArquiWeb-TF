package com.upc.ecochipstf.interfaces;

import com.upc.ecochipstf.dto.SolicitudDTO;

import java.util.List;

public interface ISolicitudService {
    public SolicitudDTO crearSolicitud(SolicitudDTO solicitudDTO);       // Moderador
    public SolicitudDTO aprobarSolicitud(Long solicitudId, Long adminId); // Admin
    public SolicitudDTO rechazarSolicitud(Long solicitudId, Long adminId); // Admin
    public List<SolicitudDTO> listarSolicitudes();
    public SolicitudDTO obtenerSolicitudPorId(Long id);
}
