package com.fencepro.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class RegistroEntrenadorRequest {
    //Datos usuario
    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    private String telefono;

    //Datos específicos entrenador
    private String dni;
    private LocalDate fechaNacimiento;
    private String titulacion;
    private Integer anosExperiencia;
    private String numeroLicencia;

    @NotNull(message = "La especialidad es campo obligatorio")
    @JsonProperty("especialidad")
    private String especialidad;
}
