package com.fencepro.model.entity; // Ajustado a tu package

import com.fencepro.model.enums.*;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.math.BigDecimal;

/**
 * Entidad que representa un torneo o campeonato.
 * Mapea la tabla 'competiciones'.
 */
@Entity
@Table(name = "competiciones")
@Data
public class Competicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @Column(nullable = false)
    private String ubicacion;

    // Enum Arma: Define si el torneo es de Florete, Espada o Sable
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Arma arma;

    // Enum Categoria: Define la edad (M15, M20, ABS...)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

    // Enum NivelCompeticion: LOCAL, NACIONAL, INTERNACIONAL
    // Determina qué nivel de árbitro se necesita
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NivelCompeticion nivel;

    @Column(name = "capacidad_maxima")
    private Integer capacidadMaxima;

    // Usamos BigDecimal para dinero (importante para precisión decimal)
    @Column(name = "precio_inscripcion", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioInscripcion;

    // Enum EstadoCompeticion: ABIERTA, EN_CURSO, FINALIZADA...
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) DEFAULT 'ABIERTA'")
    private EstadoCompeticion estado;

    // (Opcional) Árbitro principal del torneo
    @ManyToOne
    @JoinColumn(name = "arbitro_id")
    private Arbitro arbitro;
}