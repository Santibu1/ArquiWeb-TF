package com.upc.ecochipstf.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlanDTO {
    private Long planId;
    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;
    @NotNull(message = "El precio no pueden ser nulo")
    @Min(value = 0, message = "El precio no puede ser negativo")
    private Double costo;
    @NotNull(message = "Los días no pueden ser nulo")
    @Min(value = 0, message = "Los días no pueden ser negativo")
    private Integer duracionDias;
    private Double porcentajeExtra;
    private String estado;
}
