package com.fencepro.model.entity;

import com.fencepro.model.enums.*;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

/**
 * Entidad que representa a un tirador/esgrimista.
 * Mapea la tabla 'deportistas'.
 */
@Entity
@Table(name = "deportistas")
@Data
public class Deportista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación 1 a 1 con Usuario (Login)
    @OneToOne
    @JoinColumn(name = "usuario_id", unique = true, nullable = false)
    private Usuario usuario;

    // Relación Muchos a 1: Muchos deportistas pueden pertenecer a un mismo Club.
    // Puede ser NULL si el deportista es independiente.
    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @Column(unique = true, nullable = false, length = 20)
    private String dni;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    // Enum Genero: MASCULINO, FEMENINO, OTRO
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genero genero;

    @Column(name = "foto_url")
    private String fotoUrl;

    // Enum Categoria: M15, M17, M20, ABS
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

    // Enum NivelTecnico: INICIACION, INTERMEDIO, AVANZADO, COMPETICION
    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_tecnico", nullable = false)
    private NivelTecnico nivelTecnico;

    // Enum Arma: FLORETE, ESPADA, SABLE
    @Enumerated(EnumType.STRING)
    @Column(name = "arma_principal", nullable = false)
    private Arma armaPrincipal;

    // --- BLOQUE DE SALUD Y EMERGENCIA ---

    @Column(name = "contacto_emergencia", length = 150)
    private String contactoEmergencia;

    @Column(name = "telefono_emergencia", length = 20)
    private String telefonoEmergencia;

    @Column(name = "grupo_sanguineo", length = 5)
    private String grupoSanguineo;

    // Mapeado como TEXT en BBDD para permitir descripciones largas
    @Column(columnDefinition = "TEXT")
    private String alergias;

    @Column(columnDefinition = "TEXT")
    private String lesiones;
}