package com.upc.ecochipstf.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsolicitud", nullable = false)
    private Long solicitudId;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado = "PENDIENTE";

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion = LocalDate.now();

    @Column(name = "fecha_revision")
    private LocalDate fechaRevision;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idModerador", nullable = false)
    private Usuario moderador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAdmin")
    private Usuario administrador;

    @OneToOne(mappedBy = "solicitud", cascade = CascadeType.ALL)
    private Comunidad comunidad;
}
