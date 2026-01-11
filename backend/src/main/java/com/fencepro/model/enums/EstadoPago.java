package com.fencepro.model.enums;

/**
 * Enum que representa el estado de un pago
 * Corresponde al ENUM 'estado' en la tabla 'pagos'
 */
public enum EstadoPago {
    PENDIENTE("Pendiente de pago", false),
    COMPLETADO("Pago completado", true),
    FALLIDO("Pago fallido", false),
    REEMBOLSADO("Pago reembolsado", false);

    private final String descripcion;
    private final boolean pagado;

    EstadoPago(String descripcion, boolean pagado) {
        this.descripcion = descripcion;
        this.pagado = pagado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isPagado() {
        return pagado;
    }

    /**
     * Verifica si el pago está completado
     */
    public boolean estaCompletado() {
        return this == COMPLETADO;
    }

    /**
     * Obtiene el estado a partir de su nombre (case-insensitive)
     */
    public static EstadoPago fromString(String estado) {
        if (estado == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo");
        }
        try {
            return EstadoPago.valueOf(estado.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Estado de pago inválido: " + estado);
        }
    }
}
