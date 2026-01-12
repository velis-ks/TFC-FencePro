package com.fencepro.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * Entidad para el control de asistencia.
 * Mapea la tabla 'asistencias'.
 * Evita duplicados: un deportista no puede tener dos registros para el mismo entrenamiento.
 */
@Entity
@Table(name = "asistencias",
        uniqueConstraints = @UniqueConstraint(columnNames = {"entrenamiento_id", "deportista_id"})
)
@Data
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "entrenamiento_id", nullable = false)
    private Entrenamiento entrenamiento;

    @ManyToOne
    @JoinColumn(name = "deportista_id", nullable = false)
    private Deportista deportista;

    // Indica si realmente asistió o faltó
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean asistio;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        if (asistio == null) asistio = false;
    }
}