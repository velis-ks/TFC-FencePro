package com.fencepro.model.entity;

import com.fencepro.model.enums.*;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entidad financiera.
 * Mapea la tabla 'pagos'.
 */
@Entity
@Table(name = "pagos")
@Data
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // El usuario que realiza el pago (Deportista, Club, etc.)
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    // Enum ConceptoPago: LICENCIA, INSCRIPCION...
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConceptoPago concepto;

    // Enum MetodoPago: TARJETA, BIZUM...
    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago", nullable = false)
    private MetodoPago metodoPago;

    // Enum EstadoPago: PENDIENTE, COMPLETADO...
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20) DEFAULT 'PENDIENTE'")
    private EstadoPago estado;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

    // Referencia única (ej: PAY-20251230-XYZ)
    @Column(name = "referencia_pago", unique = true, length = 100)
    private String referenciaPago;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @PrePersist
    protected void onCreate() {
        if (fechaPago == null) {
            fechaPago = LocalDateTime.now();
        }
    }
}