package com.fencepro.model.enums;

/**
 * Enum que representa los roles de usuario en el sistema FencePro
 * Corresponde al ENUM 'rol' en la tabla 'usuarios'
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

    /**
     * Obtiene el rol a partir de su nombre (case-insensitive)
     */
    public static Rol fromString(String rol) {
        if (rol == null) {
            throw new IllegalArgumentException("El rol no puede ser nulo");
        }
        try {
            return Rol.valueOf(rol.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Rol inválido: " + rol);
        }
    }
}
