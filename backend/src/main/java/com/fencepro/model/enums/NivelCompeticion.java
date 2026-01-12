package com.fencepro.model.enums;

/**
 * Ámbito del torneo.
 * Mapeado con tabla 'competiciones'.
 */
public enum NivelCompeticion {
    LOCAL("Local", 1),          // Nivel árbitro requerido: 1 (Autonómico)
    AUTONOMICO("Autonómico", 1),
    NACIONAL("Nacional", 2),    // Nivel árbitro requerido: 2 (Nacional)
    INTERNACIONAL("Internacional", 3); // Nivel árbitro requerido: 3 (Internacional)

    private final String descripcion;
    private final int nivelMinimoArbitro;

    NivelCompeticion(String descripcion, int nivelMinimoArbitro) {
        this.descripcion = descripcion;
        this.nivelMinimoArbitro = nivelMinimoArbitro;
    }

    public String getDescripcion() { return descripcion; }
    public int getNivelMinimoArbitro() { return nivelMinimoArbitro; }
}