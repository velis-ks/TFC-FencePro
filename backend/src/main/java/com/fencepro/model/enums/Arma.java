package com.fencepro.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Las tres armas de la esgrima.
 * Usado en 'deportistas', 'competiciones' y 'entrenamientos'.
 */
public enum Arma {
    FLORETE("Florete", "Arma ligera, tocado en tronco"),
    ESPADA("Espada", "Arma pesada, tocado en todo el cuerpo"),
    SABLE("Sable", "Arma de corte y punta, tocado de cintura arriba");

    private final String nombre;
    private final String descripcion;

    Arma(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }

    @JsonCreator
    public static Arma fromString(String value) {
        if(value == null) return null;
        try{
            return Arma.valueOf(value.toUpperCase());
        }catch(IllegalArgumentException e){
            throw new RuntimeException("Solo se permiten valores: FLORETE, SABLE, ESPADA");
        }
    }
    @JsonValue
    public String toValue() {
        return this.name();
    }
}