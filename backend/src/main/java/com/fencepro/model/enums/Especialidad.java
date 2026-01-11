package com.fencepro.model.enums;

/**
 * Enum que representa la especialidad de los entrenadores
 * Corresponde al ENUM 'especialidad' en la tabla 'entrenadores'
 */
public enum Especialidad {
    FLORETE("Florete", "Especialista en florete"),
    ESPADA("Espada", "Especialista en espada"),
    SABLE("Sable", "Especialista en sable"),
    TODAS("Todas las armas", "Entrenador polivalente");

    private final String nombre;
    private final String descripcion;

    Especialidad(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Verifica si puede entrenar un arma específica
     */
    public boolean puedeEntrenar(Arma arma) {
        if (this == TODAS) {
            return true;
        }
        return this.name().equals(arma.name());
    }

    /**
     * Obtiene la especialidad a partir de su nombre (case-insensitive)
     */
    public static Especialidad fromString(String especialidad) {
        if (especialidad == null) {
            throw new IllegalArgumentException("La especialidad no puede ser nula");
        }
        try {
            return Especialidad.valueOf(especialidad.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Especialidad inválida: " + especialidad);
        }
    }
}
