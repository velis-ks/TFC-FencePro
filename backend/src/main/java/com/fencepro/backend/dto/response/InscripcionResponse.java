package com.fencepro.backend.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class InscripcionResponse {
    private Long id;
    private String nombreDeportista;
    private String apellidosDeportista;
    private String emailDeportista;
    private String nombreCompeticion;
    private String estado;
    private LocalDateTime fechaInscripcion;
}
