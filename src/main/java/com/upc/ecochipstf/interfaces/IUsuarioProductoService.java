package com.upc.ecochipstf.interfaces;

import com.upc.ecochipstf.dto.UsuarioProductoRequestDTO;
import com.upc.ecochipstf.dto.UsuarioProductoResponseDTO;

import java.util.List;

public interface IUsuarioProductoService {
    public UsuarioProductoResponseDTO canjear(UsuarioProductoRequestDTO requestDTO);
    List<UsuarioProductoResponseDTO> historial(Long usuarioId);
}
