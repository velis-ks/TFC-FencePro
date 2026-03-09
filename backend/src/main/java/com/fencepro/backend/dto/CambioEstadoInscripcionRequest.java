package com.fencepro.backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CambioEstadoInscripcionRequest {
    @NotNull(message = "Valor obligatorio: ESTADO - CONFIRMADA, CANCELADA, PENDIENTE")
    private String nuevoEstado;
}
