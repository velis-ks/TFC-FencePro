package com.fencepro.backend.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CrearCompeticionRequest {
    @NotNull(message = "El nombre de la competición es obligatorio")
    private String nombre;

    private String descripcion;

    @NotNull(message = "La fecha de inicio es obligatoria")
    @Future(message = "No se permite el alta de competiciones pasadas")
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de fin es obligatoria")
    private LocalDate fechaFin;

    @NotNull(message = "La localización es obligatoria")
    private String ubicacion;

    //Enums
    @NotNull(message = "Valores arma válidos: ESPADA, FLORETE, SABLE")
    private String arma;

    @NotNull(message = "Valores categoría válidos: M15, M17, M20, ABS")
    private String categoria;

    @NotNull(message = "Valores nivel válidos: LOCAL, AUTONÓMICO, NACIONAL, INTERNACIONAL")
    private String nivel;

    private Integer capacidadMaxima;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.0", message = "El precio no puede ser negativo")
    private BigDecimal precioInscripcion;

    private Long arbitroId;
}
