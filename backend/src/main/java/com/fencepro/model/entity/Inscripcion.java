package com.fencepro.model.entity;

import com.fencepro.model.enums.EstadoInscripcion;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * Entidad que gestiona la participación de un deportista en un torneo.
 * Mapea la tabla 'inscripciones'.
 * Incluye restricción única para que no se inscriba dos veces al mismo torneo.
 */
@Entity
@Table(name = "inscripciones",
        uniqueConstraints = @UniqueConstraint(columnNames = {"deportista_id", "competicion_id"})
)
@Data
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "competicion_id", nullable = false)
    private Competicion competicion;

    @ManyToOne
    @JoinColumn(name = "deportista_id", nullable = false)
    private Deportista deportista;

    // Enum EstadoInscripcion: PENDIENTE, CONFIRMADA, CANCELADA
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) DEFAULT 'PENDIENTE'")
    private EstadoInscripcion estado;

    @Column(name = "fecha_inscripcion")
    private LocalDateTime fechaInscripcion;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @PrePersist
    protected void onCreate() {
        fechaInscripcion = LocalDateTime.now();
    }
}