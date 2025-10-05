package com.upc.ecochipstf.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEventoDTO {
    private Long id;
    private Long usuarioId;
    private Long eventoId;
    private int puntosGanados;
    private String estado;///
}