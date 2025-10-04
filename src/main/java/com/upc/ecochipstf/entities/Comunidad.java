package com.upc.ecochipstf.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comunidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcomunidad", nullable = false)
    private Long comunidadId;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "estado", length = 20, nullable = false)
    private String estado = "ACTIVA";

    @OneToOne
    @JoinColumn(name = "idsolicitud", nullable = false)
    private Solicitud solicitud;

    @ManyToMany
    @JoinTable(
            name = "usuario_comunidad",
            joinColumns = @JoinColumn(name = "idcomunidad"),
            inverseJoinColumns = @JoinColumn(name = "idusuario")
    )
    private List<Usuario> miembros;
}
