package com.fencepro.model.entity;

import com.fencepro.model.enums.NivelArbitro;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

/**
 * Entidad para los árbitros de competición.
 * Mapea la tabla 'arbitros'.
 */
@Entity
@Table(name = "arbitros")
@Data
public class Arbitro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación 1 a 1 con Usuario
    @OneToOne
    @JoinColumn(name = "usuario_id", unique = true, nullable = false)
    private Usuario usuario;

    @Column(unique = true, nullable = false)
    private String dni;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    // Enum NivelArbitro: AUTONOMICO, NACIONAL, INTERNACIONAL
    // Importante para validar qué torneos pueden arbitrar
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NivelArbitro nivel;

    @Column(name = "numero_licencia", unique = true)
    private String numeroLicencia;

    @Column(name = "fecha_certificacion")
    private LocalDate fechaCertificacion;

    // Contador estadístico de torneos arbitrados
    @Column(name = "competiciones_arbitradas")
    private Integer competicionesArbitradas;
}