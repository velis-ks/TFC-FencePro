package com.fencepro.model.enums;

/**
 * Enum que representa el sexo del deportista
 * Corresponde al ENUM 'sexo' en la tabla 'deportistas'
 */
public enum Sexo {
    M("Masculino"),
    F("Femenino");

    private final String descripcion;

    Sexo(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el sexo a partir de su código (case-insensitive)
     */
    public static Sexo fromString(String sexo) {
        if (sexo == null) {
            throw new IllegalArgumentException("El sexo no puede ser nulo");
        }
        try {
            return Sexo.valueOf(sexo.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Sexo inválido: " + sexo);
        }
    }
}
