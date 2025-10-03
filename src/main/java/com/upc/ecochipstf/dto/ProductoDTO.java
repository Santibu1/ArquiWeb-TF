package com.upc.ecochipstf.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ProductoDTO {

    private Long productoId;
    private String nombre;
    private String categoria;
    private Double precio;
    private Integer stock;
    private String estado;
    private Long empresaId;
}
