package com.fencepro.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fencepro.model.enums.Genero;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroDeportistaRequest {

    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    private String dni;
    private LocalDate fechaNacimiento;
    private Genero genero;
    private String telefono;

    @NotNull(message = "El arma principal es obligatoria")
    @JsonProperty("armaPrincipal")
    private String armaPrincipal;

    @JsonProperty("nivelTecnico")
    private String nivelTecnico;
}