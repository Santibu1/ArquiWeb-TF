package com.upc.ecochipstf.interfaces;

import com.upc.ecochipstf.dto.ActividadDTO;
import com.upc.ecochipstf.dto.UsuarioActividadDTO;

import java.util.List;

public interface IUsuarioActividadService {
    public UsuarioActividadDTO completarActividad(Long actividadId, Long usuarioId);
    public List<UsuarioActividadDTO> listarActividadesPorUsuario(Long usuarioId);
    public List<UsuarioActividadDTO> listarUsuariosPorActividad(Long actividadId);

}
