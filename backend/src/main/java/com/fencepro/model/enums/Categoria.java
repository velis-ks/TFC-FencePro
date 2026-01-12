package com.fencepro.model.enums;

/**
 * Categorías de edad oficiales.
 * Mapeado estrictamente con el ENUM 'categoria' de las tablas 'deportistas' y 'competiciones'.
 */
public enum Categoria {
    M15("M15", "Menores de 15 años", 0, 15),
    M17("M17", "Cadetes (15-17 años)", 15, 17),
    M20("M20", "Junior (17-20 años)", 17, 20), // Corregido según SQL
    ABS("ABS", "Absoluta / Senior (+20)", 20, 99); // Corregido según SQL

    private final String nombreDb;
    private final String descripcion;
    private final int edadMinima;
    private final int edadMaxima;

    Categoria(String nombreDb, String descripcion, int edadMinima, int edadMaxima) {
        this.nombreDb = nombreDb;
        this.descripcion = descripcion;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
    }

    public String getDescripcion() { return descripcion; }

    // Lógica útil para asignar categoría automática
    public static Categoria fromEdad(int edad) {
        if (edad < 15) return M15;
        if (edad < 17) return M17;
        if (edad < 20) return M20;
        return ABS;
    }
}