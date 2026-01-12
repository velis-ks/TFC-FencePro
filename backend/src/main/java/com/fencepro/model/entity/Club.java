package com.fencepro.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

/**
 * Entidad que representa un Club de Esgrima.
 * Mapea la tabla 'clubes'.
 */
@Entity
@Table(name = "clubes")
@Data
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación 1 a 1: Un Club "es" un Usuario.
    // Si borras el Usuario, se borra el Club (Cascade).
    @OneToOne
    @JoinColumn(name = "usuario_id", unique = true, nullable = false)
    private Usuario usuario;

    @Column(name = "nombre_club", nullable = false, length = 200)
    private String nombreClub;

    // Código de Identificación Fiscal (único)
    @Column(unique = true, nullable = false, length = 20)
    private String cif;

    // Dirección física
    private String direccion;
    private String ciudad;
    private String provincia;

    @Column(name = "codigo_postal", length = 10)
    private String codigoPostal;

    @Column(length = 150)
    private String presidente;

    @Column(name = "email_club", length = 100)
    private String emailClub;

    @Column(name = "telefono_club", length = 20)
    private String telefonoClub;

    @Column(name = "fecha_fundacion")
    private LocalDate fechaFundacion;
}