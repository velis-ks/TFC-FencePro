package com.fencepro.model.enums;

/**
 * Enum que representa el método de pago
 * Corresponde al ENUM 'metodo_pago' en la tabla 'pagos'
 */
public enum MetodoPago {
    TARJETA("Tarjeta de crédito/débito"),
    TRANSFERENCIA("Transferencia bancaria"),
    PAYPAL("PayPal"),
    EFECTIVO("Efectivo");

    private final String descripcion;

    MetodoPago(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Verifica si es un método de pago online
     */
    public boolean esOnline() {
        return this == TARJETA || this == PAYPAL;
    }

    /**
     * Obtiene el método a partir de su nombre (case-insensitive)
     */
    public static MetodoPago fromString(String metodo) {
        if (metodo == null) {
            throw new IllegalArgumentException("El método de pago no puede ser nulo");
        }
        try {
            return MetodoPago.valueOf(metodo.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Método de pago inválido: " + metodo);
        }
    }
}
