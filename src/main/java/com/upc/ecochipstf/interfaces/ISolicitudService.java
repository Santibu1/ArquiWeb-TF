package com.upc.ecochipstf.interfaces;

import com.upc.ecochipstf.dto.SolicitudRequestDTO;
import com.upc.ecochipstf.dto.SolicitudResponseDTO;

import java.util.List;

public interface ISolicitudService {
    public SolicitudResponseDTO crearSolicitud(SolicitudRequestDTO solicitudDTO);   // moderador
    public SolicitudResponseDTO aprobarSolicitud(Long solicitudId, Long adminId);   // admin
    public SolicitudResponseDTO rechazarSolicitud(Long solicitudId, Long adminId);  // admin
    public List<SolicitudResponseDTO> listarSolicitudes();
    public SolicitudResponseDTO obtenerSolicitudPorId(Long id);
}
