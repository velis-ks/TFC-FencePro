package com.fencepro.model.entity;

import com.fencepro.model.enums.Rol;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * Entidad que representa a cualquier usuario del sistema.
 * Mapea la tabla 'usuarios'.
 * Todos los actores (Deportista, Entrenador, Club...) tienen un Usuario asociado.
 */
@Entity
@Table(name = "usuarios")
@Data // Lombok: Genera Getters, Setters, toString, equals, hashcode automáticamente
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremental en MySQL
    private Long id;

    // El email es el username para el login. Debe ser único.
    @Column(unique = true, nullable = false, length = 100)
    private String email;

    // En BBDD se llama 'password_hash', en Java lo llamamos 'password'
    @Column(name = "password_hash", nullable = false)
    private String password;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 150)
    private String apellidos;

    @Column(length = 20)
    private String telefono;

    // Guardamos el nombre del Enum ("ADMIN") en la BBDD, no el número
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    // Por defecto es TRUE según el script SQL
    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean activo;

    @Column(name = "email_verificado")
    private Boolean emailVerificado;

    /**
     * Se ejecuta automáticamente antes de insertar un nuevo usuario en la BBDD.
     * Inicializa la fecha de registro y el estado activo.
     */
    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        if (activo == null) {
            activo = true;
        }
    }
}