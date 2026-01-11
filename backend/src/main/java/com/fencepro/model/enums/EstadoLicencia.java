package com.fencepro.model.enums;

/**
 * Enum que representa el estado de una licencia
 * Corresponde al ENUM 'estado' en la tabla 'licencias'
 */
public enum EstadoLicencia {
    PENDIENTE("Pendiente de aprobación", false),
    APROBADA("Aprobada y vigente", true),
    RECHAZADA("Rechazada", false),
    CADUCADA("Caducada", false);

    private final String descripcion;
    private final boolean vigente;

    EstadoLicencia(String descripcion, boolean vigente) {
        this.descripcion = descripcion;
        this.vigente = vigente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isVigente() {
        return vigente;
    }

    /**
     * Verifica si la licencia está activa
     */
    public boolean estaActiva() {
        return this == APROBADA;
    }

    /**
     * Obtiene el estado a partir de su nombre (case-insensitive)
     */
    public static EstadoLicencia fromString(String estado) {
        if (estado == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo");
        }
        try {
            return EstadoLicencia.valueOf(estado.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Estado de licencia inválido: " + estado);
        }
    }
}
