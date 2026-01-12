package com.fencepro.model.enums;

/**
 * Rango del árbitro.
 * Mapeado con tabla 'arbitros'.
 */
public enum NivelArbitro {
    AUTONOMICO("Autonómico", 1),
    NACIONAL("Nacional", 2),
    INTERNACIONAL("Internacional", 3);

    private final String descripcion;
    private final int rango;

    NivelArbitro(String descripcion, int rango) {
        this.descripcion = descripcion;
        this.rango = rango;
    }

    public String getDescripcion() { return descripcion; }

    // Verifica si puede arbitrar un torneo según su nivel
    public boolean puedeArbitrar(NivelCompeticion torneo) {
        return this.rango >= torneo.getNivelMinimoArbitro();
    }
}