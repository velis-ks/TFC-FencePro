package com.fencepro.model.enums;

/**
 * Motivo del pago.
 * Mapeado con tabla 'pagos'.
 */
public enum ConceptoPago {
    LICENCIA("Pago de licencia federativa"),
    INSCRIPCION_COMPETICION("Inscripción a torneo"),
    CUOTA("Cuota de club");

    private final String descripcion;

    ConceptoPago(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() { return descripcion; }
}