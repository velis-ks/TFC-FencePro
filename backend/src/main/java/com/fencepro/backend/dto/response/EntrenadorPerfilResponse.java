package com.fencepro.backend.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrenadorPerfilResponse {
    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private String dni;
    private String especialidad;
    private String titulacion;
    private Integer anosExperiencia;
    private String numeroLicencia;
    private String rol;
}
