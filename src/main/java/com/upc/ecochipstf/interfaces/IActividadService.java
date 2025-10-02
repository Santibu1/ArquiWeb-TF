package com.upc.ecochipstf.interfaces;

import com.upc.ecochipstf.dto.ActividadDTO;

import java.util.List;

public interface IActividadService {
    public ActividadDTO crearActividad(ActividadDTO actividadDTO);         // admin
    public List<ActividadDTO> listarActividadesActivas();
    public ActividadDTO obtenerActividadPorId(Long id);
    public ActividadDTO actualizarActividad(ActividadDTO actividadDTO);
    public void eliminarActividad(Long id);

}
