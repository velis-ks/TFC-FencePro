package com.fencepro.model.enums;

/**
 * Estado del deportista en un torneo específico.
 * Mapeado con tabla 'inscripciones'.
 */
public enum EstadoInscripcion {
    PENDIENTE("Pendiente de validación/pago"),
    CONFIRMADA("Inscripción aceptada"),
    CANCELADA("Baja del torneo");

    private final String descripcion;

    EstadoInscripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() { return descripcion; }
}