package com.fencepro.model.enums;

/**
 * Forma de pago.
 * Mapeado con tabla 'pagos'.
 */
public enum MetodoPago {
    TARJETA("Tarjeta Crédito/Débito"),
    TRANSFERENCIA("Transferencia Bancaria"),
    EFECTIVO("Pago en metálico"),
    BIZUM("Bizum");

    private final String descripcion;

    MetodoPago(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() { return descripcion; }
}