package com.fencepro.model.entity;

import com.fencepro.model.enums.*;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Entidad administrativa para licencias federativas.
 * Mapea la tabla 'licencias'.
 */
@Entity
@Table(name = "licencias")
@Data
public class Licencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Enum TipoLicencia: DEPORTISTA, ENTRENADOR...
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_licencia", nullable = false)
    private TipoLicencia tipoLicencia;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    // Enum EstadoLicencia: VIGENTE, CADUCADA...
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) DEFAULT 'PENDIENTE'")
    private EstadoLicencia estado;

    // Relación opcional con Pago (se puede generar licencia tras pagar)
    @ManyToOne
    @JoinColumn(name = "pago_id")
    private Pago pago;

    @Column(name = "fecha_solicitud")
    private LocalDateTime fechaSolicitud;

    @PrePersist
    protected void onCreate() {
        fechaSolicitud = LocalDateTime.now();
    }
}