package com.fencepro.model.enums;

/**
 * Tipo de licencia.
 * Mapeado con tabla 'licencias'.
 */
public enum TipoLicencia {
    DEPORTISTA("Licencia Deportiva", 50.0),
    ENTRENADOR("Licencia Técnico", 75.0),
    ARBITRO("Licencia Árbitro", 60.0),
    CLUB("Licencia Entidad", 200.0);

    private final String descripcion;
    private final double precioBase;

    TipoLicencia(String descripcion, double precioBase) {
        this.descripcion = descripcion;
        this.precioBase = precioBase;
    }

    public double getPrecio() { return precioBase; }
}
