package com.fencepro.backend.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class CompeticionResponse {
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String ubicacion;
    private String arma;
    private String categoria;
    private String nivel;
    private String estado;
    private Integer capacidadMaxima;
    private Integer inscritosActuales; //Dato calculado para el Frontend
    private BigDecimal precioInscripcion;
}
