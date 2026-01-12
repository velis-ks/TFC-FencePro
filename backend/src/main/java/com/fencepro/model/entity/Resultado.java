package com.fencepro.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

/**
 * Entidad para los resultados finales.
 * Mapea la tabla 'resultados'.
 */
@Entity
@Table(name = "resultados")
@Data
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación 1 a 1 con Inscripción: Una inscripción tiene un único resultado final
    @OneToOne
    @JoinColumn(name = "inscripcion_id", unique = true, nullable = false)
    private Inscripcion inscripcion;

    // Redundancia controlada para búsquedas rápidas por torneo
    @ManyToOne
    @JoinColumn(name = "competicion_id", nullable = false)
    private Competicion competicion;

    @Column(nullable = false)
    private Integer posicion;

    private BigDecimal puntuacion;

    @Column(length = 20)
    private String medalla; // ORO, PLATA, BRONCE

    @Column(columnDefinition = "TEXT")
    private String observaciones;
}