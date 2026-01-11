package com.fencepro.model.enums;

/**
 * Enum que representa las categorías de edad de los deportistas
 * Corresponde al ENUM 'categoria' en la tabla 'deportistas'
 */
public enum Categoria {
    INFANTIL("Infantil", "Menores de 11 años", 0, 10),
    CADETE("Cadete", "De 11 a 13 años", 11, 13),
    JUNIOR("Junior", "De 14 a 17 años", 14, 17),
    SENIOR("Senior", "De 18 a 39 años", 18, 39),
    VETERANO("Veterano", "40 años o más", 40, 999);

    private final String nombre;
    private final String descripcion;
    private final int edadMinima;
    private final int edadMaxima;

    Categoria(String nombre, String descripcion, int edadMinima, int edadMaxima) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    /**
     * Obtiene la categoría según la edad del deportista
     */
    public static Categoria fromEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }

        for (Categoria categoria : values()) {
            if (edad >= categoria.edadMinima && edad <= categoria.edadMaxima) {
                return categoria;
            }
        }

        return VETERANO; // Por defecto si es mayor de 999 años (caso imposible)
    }

    /**
     * Obtiene la categoría a partir de su nombre (case-insensitive)
     */
    public static Categoria fromString(String categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría no puede ser nula");
        }
        try {
            return Categoria.valueOf(categoria.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Categoría inválida: " + categoria);
        }
    }
}
