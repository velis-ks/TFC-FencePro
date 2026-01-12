package com.fencepro.model.entity;

import com.fencepro.model.enums.Arma;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Entidad que representa una sesión de entrenamiento o clase.
 * Mapea la tabla 'entrenamientos'.
 */
@Entity
@Table(name = "entrenamientos")
@Data
public class Entrenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // El entrenamiento pertenece a un Club específico
    @ManyToOne
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    // El entrenador que imparte la clase
    @ManyToOne
    @JoinColumn(name = "entrenador_id", nullable = false)
    private Entrenador entrenador;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    // Enum Arma: Define de qué es la clase (Florete, Espada, Sable)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Arma arma;

    // En SQL está definido como VARCHAR(50), no como ENUM,
    // así que lo mapeamos como String (ej: "Grupo B", "Iniciación Avanzada").
    @Column(nullable = false, length = 50)
    private String nivel;

    @Column(name = "capacidad_maxima")
    private Integer capacidadMaxima;

    @Column(columnDefinition = "TEXT")
    private String descripcion;
}