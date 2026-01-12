package com.fencepro.model.enums;

/**
 * Género del deportista.
 * Mapeado estrictamente con el ENUM 'genero' de la tabla 'deportistas'.
 */
public enum Genero {
    MASCULINO("Masculino"),
    FEMENINO("Femenino"),
    OTRO("Otro");

    private final String descripcion;

    Genero(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}