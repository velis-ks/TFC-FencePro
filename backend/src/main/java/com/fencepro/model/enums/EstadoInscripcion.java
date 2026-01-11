package com.fencepro.model.enums;

/**
 * Enum que representa el estado de una inscripción
 * Corresponde al ENUM 'estado' en la tabla 'inscripciones'
 */
public enum EstadoInscripcion {
    PENDIENTE("Pendiente", "Inscripción pendiente de confirmación", false),
    CONFIRMADA("Confirmada", "Inscripción confirmada", true),
    CANCELADA("Cancelada", "Inscripción cancelada", false);

    private final String nombre;
    private final String descripcion;
    private final boolean activa;

    EstadoInscripcion(String nombre, String descripcion, boolean activa) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activa = activa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isActiva() {
        return activa;
    }

    /**
     * Verifica si la inscripción está confirmada
     */
    public boolean estaConfirmada() {
        return this == CONFIRMADA;
    }

    /**
     * Verifica si se puede cancelar
     */
    public boolean sePuedeCancelar() {
        return this == PENDIENTE || this == CONFIRMADA;
    }

    /**
     * Obtiene el estado a partir de su nombre (case-insensitive)
     */
    public static EstadoInscripcion fromString(String estado) {
        if (estado == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo");
        }
        try {
            return EstadoInscripcion.valueOf(estado.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Estado de inscripción inválido: " + estado);
        }
    }
}
