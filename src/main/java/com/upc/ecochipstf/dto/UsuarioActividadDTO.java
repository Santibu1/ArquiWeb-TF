package com.upc.ecochipstf.dto;
import lombok.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioActividadDTO {
    private Long id;
    private Long usuarioId;
    private Long actividadId;
    private String estado;
    private LocalDate fechaCompletado;
}
