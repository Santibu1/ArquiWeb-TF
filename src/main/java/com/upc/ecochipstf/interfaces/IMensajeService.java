package com.upc.ecochipstf.interfaces;

import com.upc.ecochipstf.dto.MensajeDTO;

import java.util.List;

public interface IMensajeService {
    public MensajeDTO enviarMensaje(MensajeDTO dto, String usuarioEmail);
    public List<MensajeDTO> listarMensajesPorComunidad(Long comunidadId);
}
