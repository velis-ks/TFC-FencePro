package com.fencepro.backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SolicitudInscripcionRequest {
    @NotNull(message = "Campo obligatorio: ID competición")
    private Long competicionId;
}
