package com.fencepro.model.enums;

/**
 * Especialidad del entrenador (incluye TODAS).
 * Mapeado con tabla 'entrenadores'.
 */
public enum Especialidad {
    FLORETE("Especialista Florete"),
    ESPADA("Especialista Espada"),
    SABLE("Especialista Sable"),
    TODAS("Especialista de todas las armas");

    private final String descripcion;

    Especialidad(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() { return descripcion; }

    public boolean puedeEntrenar(Arma arma) {
        return this == TODAS || this.name().equals(arma.name());
    }
}