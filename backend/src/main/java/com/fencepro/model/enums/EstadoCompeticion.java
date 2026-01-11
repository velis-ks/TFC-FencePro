package com.fencepro.model.enums;

/**
 * Enum que representa el estado de una competición
 * Corresponde al ENUM 'estado' en la tabla 'competiciones'
 */
public enum EstadoCompeticion {
    ABIERTA("Abierta", "Inscripciones abiertas", true),
    EN_CURSO("En curso", "Competición en curso", false),
    FINALIZADA("Finalizada", "Competición finalizada", false),
    CANCELADA("Cancelada", "Competición cancelada", false);

    private final String nombre;
    private final String descripcion;
    private final boolean aceptaInscripciones;

    EstadoCompeticion(String nombre, String descripcion, boolean aceptaInscripciones) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.aceptaInscripciones = aceptaInscripciones;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean aceptaInscripciones() {
        return aceptaInscripciones;
    }

    /**
     * Verifica si la competición está activa
     */
    public boolean estaActiva() {
        return this == ABIERTA || this == EN_CURSO;
    }

    /**
     * Verifica si la competición ha terminado
     */
    public boolean haTerminado() {
        return this == FINALIZADA || this == CANCELADA;
    }

    /**
     * Obtiene el estado a partir de su nombre (case-insensitive)
     */
    public static EstadoCompeticion fromString(String estado) {
        if (estado == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo");
        }

        // Manejar casos especiales con guión bajo
        String estadoNormalizado = estado.toUpperCase().replace(" ", "_");

        try {
            return EstadoCompeticion.valueOf(estadoNormalizado);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Estado de competición inválido: " + estado);
        }
    }
}
