package com.fencepro.model.enums;

/**
 * Validez de la licencia.
 * Mapeado con tabla 'licencias'.
 */
public enum EstadoLicencia {
    PENDIENTE("En trámite", false),
    APROBADA("Vigente", true),
    RECHAZADA("Denegada", false),
    CADUCADA("Vencida", false);

    private final String descripcion;
    private final boolean permiteCompetir;

    EstadoLicencia(String descripcion, boolean permiteCompetir) {
        this.descripcion = descripcion;
        this.permiteCompetir = permiteCompetir;
    }

    public boolean esValida() { return permiteCompetir; }
}