package com.fencepro.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class RegistroClubRequest {

    //Datos del usuario (ADMIN CLUB)
    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    private String telefono;

    //Datos del club específicos
    @NotNull(message = "El nombre del club es obligatorio")
    @JsonProperty("nombreClub")
    private String nombreClub;

    @NotNull(message = "El CIF es campo obligatorio")
    private String cif;

    private String direccion;
    private String ciudad;
    private String provincia;
    private String codigoPostal;
    private String presidente;
    private String emailClub; //Puede ser distinto al del login
    private String telefonoClub;
    private LocalDate fechaFundacion;
}
