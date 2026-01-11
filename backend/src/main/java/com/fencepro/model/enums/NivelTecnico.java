package com.fencepro.model.enums;

/**
 * Enum que representa el nivel técnico de los deportistas
 * Corresponde al ENUM 'nivel_tecnico' en la tabla 'deportistas'
 */
public enum NivelTecnico {
    INICIACION("Iniciación", "Nivel básico, aprendiendo fundamentos", 1),
    INTERMEDIO("Intermedio", "Domina técnicas básicas, desarrollando estrategia", 2),
    AVANZADO("Avanzado", "Técnica refinada, participa en competiciones", 3),
    COMPETICION("Competición", "Alto nivel competitivo, busca resultados", 4);

    private final String nombre;
    private final String descripcion;
    private final int orden;

    NivelTecnico(String nombre, String descripcion, int orden) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.orden = orden;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getOrden() {
        return orden;
    }

    /**
     * Verifica si este nivel es mayor o igual que otro
     */
    public boolean esMayorOIgualQue(NivelTecnico otro) {
        return this.orden >= otro.orden;
    }

    /**
     * Obtiene el nivel técnico a partir de su nombre (case-insensitive)
     */
    public static NivelTecnico fromString(String nivel) {
        if (nivel == null) {
            throw new IllegalArgumentException("El nivel técnico no puede ser nulo");
        }
        try {
            return NivelTecnico.valueOf(nivel.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Nivel técnico inválido: " + nivel);
        }
    }
}
