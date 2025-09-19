package com.upc.ecochipstf.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolId;
    private String tipoRol;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
