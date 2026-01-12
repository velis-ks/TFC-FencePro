package com.fencepro.model.enums;

/**
 * Ciclo de vida del torneo.
 * Mapeado con tabla 'competiciones'.
 */
public enum EstadoCompeticion {
    ABIERTA("Inscripciones abiertas", true),
    EN_CURSO("Competición en marcha", false),
    FINALIZADA("Competición terminada", false),
    CANCELADA("Competición suspendida", false);

    private final String descripcion;
    private final boolean permiteInscripciones;

    EstadoCompeticion(String descripcion, boolean permiteInscripciones) {
        this.descripcion = descripcion;
        this.permiteInscripciones = permiteInscripciones;
    }

    public boolean admiteInscripciones() { return permiteInscripciones; }
}