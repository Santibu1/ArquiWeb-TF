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
    @Column(name = "actividadId", nullable = false)
    private Long actividadId;

    @Column(name = "nombre", nullable = false)
    private String nombreActividad;

    @Column(name = "descripcion", nullable = false)
    private String descripcionActividad;

    @Column(name = "recompensa", nullable = false)
    private Integer recompensaActividad;

    @Column(name = "categoria", nullable = false)
    private String categoriaActividad;

    @Column(name = "estado", nullable = false)
    private String estadoActividad;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
