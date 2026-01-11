package com.fencepro.model.enums;

/**
 * Enum que representa el concepto de un pago
 * Corresponde al ENUM 'concepto' en la tabla 'pagos'
 */
public enum ConceptoPago {
    LICENCIA("Pago de licencia"),
    INSCRIPCION_COMPETICION("Inscripción a competición"),
    CUOTA_CLUB("Cuota mensual del club"),
    MATERIAL("Compra de material deportivo"),
    OTROS("Otros conceptos");

    private final String descripcion;

    ConceptoPago(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el concepto a partir de su nombre (case-insensitive)
     */
    public static ConceptoPago fromString(String concepto) {
        if (concepto == null) {
            throw new IllegalArgumentException("El concepto no puede ser nulo");
        }
        try {
            return ConceptoPago.valueOf(concepto.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Concepto de pago inválido: " + concepto);
        }
    }
}
