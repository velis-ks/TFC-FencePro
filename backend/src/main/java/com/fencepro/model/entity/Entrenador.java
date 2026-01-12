package com.fencepro.model.entity;

import com.fencepro.model.enums.Especialidad;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

/**
 * Entidad para los maestros de armas y técnicos.
 * Mapea la tabla 'entrenadores'.
 */
@Entity
@Table(name = "entrenadores")
@Data
public class Entrenador {

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

    // Enum Especialidad: Incluye FLORETE, ESPADA, SABLE y TODAS
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Especialidad especialidad;

    private String titulacion;

    @Column(name = "anos_experiencia")
    private Integer anosExperiencia;

    @Column(name = "numero_licencia", unique = true)
    private String numeroLicencia;

    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;
}