package com.fencepro.model.enums;

/**
 * Enum que representa los tipos de arma en esgrima
 * Corresponde al ENUM 'arma' en varias tablas
 */
public enum Arma {
    FLORETE("Florete", "Arma ligera, tocados con la punta en el torso"),
    ESPADA("Espada", "Arma más pesada, tocados con la punta en todo el cuerpo"),
    SABLE("Sable", "Arma de corte y punta, tocados de cintura para arriba");

    private final String nombre;
    private final String descripcion;

    Arma(String nombre, String descripcion) {
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
     * Obtiene el arma a partir de su nombre (case-insensitive)
     */
    public static Arma fromString(String arma) {
        if (arma == null) {
            throw new IllegalArgumentException("El arma no puede ser nula");
        }
        try {
            return Arma.valueOf(arma.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Arma inválida: " + arma);
        }
    }
}
