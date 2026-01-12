package com.fencepro.model.enums;

/**
 * Estado de la transacción.
 * Mapeado con tabla 'pagos'.
 */
public enum EstadoPago {
    PENDIENTE("Esperando pago", false),
    COMPLETADO("Pagado correctamente", true),
    FALLIDO("Error en el pago", false),
    REEMBOLSADO("Dinero devuelto", false);

    private final String descripcion;
    private final boolean esFinalizadoExitoso;

    EstadoPago(String descripcion, boolean esFinalizadoExitoso) {
        this.descripcion = descripcion;
        this.esFinalizadoExitoso = esFinalizadoExitoso;
    }

    public boolean estaPagado() { return esFinalizadoExitoso; }
}