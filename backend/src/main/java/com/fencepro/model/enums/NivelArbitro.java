package com.fencepro.model.enums;

/**
 * Enum que representa el nivel de un árbitro
 * Corresponde al ENUM 'nivel' en la tabla 'arbitros'
 */
public enum NivelArbitro {
    AUTONOMICO("Autonómico", "Árbitro de nivel autonómico", 1),
    NACIONAL("Nacional", "Árbitro de nivel nacional", 2),
    INTERNACIONAL_B("Internacional B", "Árbitro internacional nivel B", 3),
    INTERNACIONAL_A("Internacional A", "Árbitro internacional nivel A", 4),
    FIE("FIE", "Árbitro de la Federación Internacional de Esgrima", 5);

    private final String nombre;
    private final String descripcion;
    private final int orden;

    NivelArbitro(String nombre, String descripcion, int orden) {
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
    public boolean esMayorOIgualQue(NivelArbitro otro) {
        return this.orden >= otro.orden;
    }

    /**
     * Verifica si puede arbitrar una competición de un nivel específico
     */
    public boolean puedeArbitrar(NivelCompeticion nivelCompeticion) {
        return this.orden >= nivelCompeticion.getNivelMinimoArbitro();
    }

    /**
     * Obtiene el nivel a partir de su nombre (case-insensitive)
     */
    public static NivelArbitro fromString(String nivel) {
        if (nivel == null) {
            throw new IllegalArgumentException("El nivel no puede ser nulo");
        }

        // Manejar casos especiales con guión bajo
        String nivelNormalizado = nivel.toUpperCase().replace(" ", "_");

        try {
            return NivelArbitro.valueOf(nivelNormalizado);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Nivel de árbitro inválido: " + nivel);
        }
    }
}
