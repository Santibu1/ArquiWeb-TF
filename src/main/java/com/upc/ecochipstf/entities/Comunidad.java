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
    @Column(name = "idcomunidad")
    private Long idComunidad;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idsolicitud", nullable = false, unique = true)
    private Solicitud solicitud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_moderador", nullable = false)
    private Usuario moderador;

    @Column(name = "nombre", length = 150, nullable = false)
    private String nombre;

    @Column(name = "ubicacion", length = 100, nullable = false)
    private String ubicacion;

    @Column(name = "descripcion", length = 300)
    private String descripcion;

    @Column(name = "estado", length = 20, nullable = false)
    private String estado; // "Activa", "Inactiva"

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuario_comunidad",
            joinColumns = @JoinColumn(name = "idcomunidad"),
            inverseJoinColumns = @JoinColumn(name = "idusuario")
    )
    private List<Usuario> miembros;
}
