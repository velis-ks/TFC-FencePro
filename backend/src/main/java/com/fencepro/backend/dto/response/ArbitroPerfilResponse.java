package com.fencepro.backend.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArbitroPerfilResponse {
    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private String nivel;
    private String numeroLicencia;
    private Integer competicionesArbitradas;
    private String rol;
}
