package com.fencepro.model.enums;

/**
 * Enum que representa los tipos de licencia
 * Corresponde al ENUM 'tipo_licencia' en la tabla 'licencias'
 */
public enum TipoLicencia {
    DEPORTISTA("Licencia de Deportista", 50.00),
    ENTRENADOR("Licencia de Entrenador", 75.00),
    ARBITRO("Licencia de Árbitro", 60.00),
    CLUB("Licencia de Club", 200.00);

    private final String descripcion;
    private final double precioBase;

    TipoLicencia(String descripcion, double precioBase) {
        this.descripcion = descripcion;
        this.precioBase = precioBase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    /**
     * Obtiene el tipo de licencia a partir de su nombre (case-insensitive)
     */
    public static TipoLicencia fromString(String tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de licencia no puede ser nulo");
        }
        try {
            return TipoLicencia.valueOf(tipo.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de licencia inválido: " + tipo);
        }
    }
}
