package com.fencepro.backend.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClubPerfilResponse {
    private Long id;
    private String nombreResponsable; //nombre usuario admin
    private String emailLogin;
    private String nombreClub;
    private String cif;
    private String ciudad;
    private String emailPublico;
    private String rol;
}
