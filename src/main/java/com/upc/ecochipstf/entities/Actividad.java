package com.upc.ecochipstf.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actividadId;
    private String nombreActividad;
    private String descripcionActividad;
    private String recompensaActividad;
    private String categoriaActividad;
    private String estadoActividad;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
