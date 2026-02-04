package com.fencepro.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class RegistroArbitroRequest {

    //Datos comunes a USUARIO
    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    private String telefono;

    //Datos específicos a ÁRBITRO
    private String dni;
    private LocalDate fechaNacimiento;
    private String numeroLicencia;

    @NotNull(message = "Es obligatorio indicar el nivel")
    @JsonProperty("nivel")
    private String nivel;
}
