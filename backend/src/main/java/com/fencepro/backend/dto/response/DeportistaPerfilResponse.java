package com.fencepro.backend.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class DeportistaPerfilResponse {
    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private String dni;
    private String arma;
    private String categoria;
    private String nivelTecnico;
    private String nombreClub;
    private LocalDate fechaNacimiento;
    private String rol;
}
