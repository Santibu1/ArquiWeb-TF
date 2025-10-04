package com.upc.ecochipstf.interfaces;

import com.upc.ecochipstf.dto.ComunidadRequestDTO;
import com.upc.ecochipstf.dto.ComunidadResponseDTO;

import java.util.List;

public interface IComunidadService {
    public ComunidadResponseDTO crearComunidad(ComunidadRequestDTO comunidadDTO);   // admin
    public ComunidadResponseDTO obtenerComunidadPorId(Long id);
    public List<ComunidadResponseDTO> listarComunidades();
    public ComunidadResponseDTO actualizarComunidad(ComunidadRequestDTO comunidadDTO);
    public void eliminarComunidad(Long id);
}
