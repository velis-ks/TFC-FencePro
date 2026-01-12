package com.fencepro.model.enums;

/**
 * Nivel de destreza del deportista.
 * Mapeado con tabla 'deportistas'.
 */
public enum NivelTecnico {
    INICIACION("Iniciación", 1),
    INTERMEDIO("Intermedio", 2),
    AVANZADO("Avanzado", 3),
    COMPETICION("Competición", 4);

    private final String descripcion;
    private final int nivelNumerico;

    NivelTecnico(String descripcion, int nivelNumerico) {
        this.descripcion = descripcion;
        this.nivelNumerico = nivelNumerico;
    }

    public String getDescripcion() { return descripcion; }

    public boolean esSuperiorOIgual(NivelTecnico otro) {
        return this.nivelNumerico >= otro.nivelNumerico;
    }
}