package com.fencepro.model.entity;

import com.fencepro.model.enums.Rol;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

/**
 * Entidad que representa un usuario del sistema FencePro
 * Tabla base para todos los tipos de usuarios (Admin, Club, Entrenador, Deportista, Árbitro)
 */
@Entity
@Table(name = "usuarios", indexes = {
        @Index(name = "idx_email", columnList = "email"),
        @Index(name = "idx_rol", columnList = "rol")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe ser válido")
    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "Los apellidos son obligatorios")
    @Column(nullable = false, length = 150)
    private String apellidos;

    @Column(length = 20)
    private String telefono;

    @NotNull(message = "El rol es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;

    @CreationTimestamp
    @Column(name = "fecha_registro", nullable = false, updatable = false)
    private LocalDateTime fechaRegistro;

    @Column(nullable = false)
    @Builder.Default
    private Boolean activo = true;

    @Column(name = "email_verificado", nullable = false)
    @Builder.Default
    private Boolean emailVerificado = false;

    // Relaciones (lazy loading por defecto)
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Club club;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Deportista deportista;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Entrenador entrenador;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Arbitro arbitro;

    /**
     * Obtiene el nombre completo del usuario
     */
    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    /**
     * Verifica si el usuario está activo y verificado
     */
    public boolean estaActivoYVerificado() {
        return activo && emailVerificado;
    }

    /**
     * Verifica si el usuario tiene un rol específico
     */
    public boolean tieneRol(Rol rol) {
        return this.rol == rol;
    }
}
