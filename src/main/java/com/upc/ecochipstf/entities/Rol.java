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
    @Column(name = "rolId", nullable = false)
    private Long rolId;

    @Column(name = "tipo", nullable = false, length = 100)
    private String tipoRol;
}
