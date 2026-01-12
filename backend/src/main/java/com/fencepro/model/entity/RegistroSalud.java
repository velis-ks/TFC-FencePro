package com.fencepro.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Entidad para el seguimiento físico y médico.
 * Mapea la tabla 'registros_salud'.
 */
@Entity
@Table(name = "registros_salud")
@Data
public class RegistroSalud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "deportista_id", nullable = false)
    private Deportista deportista;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    // BigDecimal para precisión en medidas
    @Column(precision = 5, scale = 2)
    private BigDecimal peso;

    @Column(precision = 5, scale = 2)
    private BigDecimal altura;

    @Column(name = "frecuencia_cardiaca")
    private Integer frecuenciaCardiaca;

    @Column(name = "presion_arterial", length = 20)
    private String presionArterial;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    // Control de certificado médico obligatorio para competir
    @Column(name = "certificado_medico")
    private Boolean certificadoMedico;

    @Column(name = "fecha_certificado")
    private LocalDate fechaCertificado;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
    }
}