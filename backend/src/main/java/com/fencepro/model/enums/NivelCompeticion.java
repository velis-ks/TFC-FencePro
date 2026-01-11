package com.fencepro.model.enums;

/**
 * Enum que representa el nivel de una competición
 * Corresponde al ENUM 'nivel' en la tabla 'competiciones'
 */
public enum NivelCompeticion {
    LOCAL("Local", "Competición local", 1),
    AUTONOMICO("Autonómico", "Competición autonómica", 2),
    NACIONAL("Nacional", "Competición nacional", 3),
    INTERNACIONAL("Internacional", "Competición internacional", 4),
    COPA_MUNDO("Copa del Mundo", "Copa del Mundo", 5),
    CAMPEONATO_MUNDIAL("Campeonato Mundial", "Campeonato Mundial", 6),
    JUEGOS_OLIMPICOS("Juegos Olímpicos", "Juegos Olímpicos", 7);

    private final String nombre;
    private final String descripcion;
    private final int nivelMinimoArbitro;

    NivelCompeticion(String nombre, String descripcion, int nivelMinimoArbitro) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivelMinimoArbitro = nivelMinimoArbitro;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getNivelMinimoArbitro() {
        return nivelMinimoArbitro;
    }

    /**
     * Verifica si requiere árbitro internacional
     */
    public boolean requiereArbitroInternacional() {
        return this.nivelMinimoArbitro >= 3;
    }

    /**
     * Obtiene el nivel a partir de su nombre (case-insensitive)
     */
    public static NivelCompeticion fromString(String nivel) {
        if (nivel == null) {
            throw new IllegalArgumentException("El nivel no puede ser nulo");
        }

        // Manejar casos especiales con guión bajo
        String nivelNormalizado = nivel.toUpperCase().replace(" ", "_");

        try {
            return NivelCompeticion.valueOf(nivelNormalizado);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Nivel de competición inválido: " + nivel);
        }
    }
}
