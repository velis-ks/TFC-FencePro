package com.fencepro.model.enums;

/**
 * Roles de usuario permitidos en el sistema.
 * Mapeado estrictamente con el ENUM 'rol' de la tabla 'usuarios'.
 */
public enum Rol {
    ADMIN("Administrador del sistema"),
    CLUB("Representante de club"),
    ENTRENADOR("Entrenador"),
    DEPORTISTA("Deportista"),
    ARBITRO("Árbitro");

    private final String descripcion;

    Rol(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}