package com.fencepro.backend.controller;

import com.fencepro.backend.dto.CambioEstadoInscripcionRequest;
import com.fencepro.backend.dto.SolicitudInscripcionRequest;
import com.fencepro.backend.dto.response.InscripcionResponse;
import com.fencepro.backend.service.InscripcionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
@RequiredArgsConstructor
@Tag(name = "Inscripciones", description = "Gestión de INSCRIPCIONES en torneos")
public class InscripcionController {

    private final InscripcionService inscripcionService;

    @Operation(
            summary = "Solicitud de inscripción (Deportista)",
            description = "DEPORTISTA solicita participar en un torneo o evento",
            security = @SecurityRequirement(name="bearerAuth")
    )
    @PostMapping("/solicitar")
    @PreAuthorize("hasRole('DEPORTISTA')")
    public ResponseEntity<?> solicitarInscripcion(@Valid @RequestBody SolicitudInscripcionRequest request){
        //Quién se inscribe (TOKEN)
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

            var inscripcion = inscripcionService.inscribirse(email, request);
            return ResponseEntity.ok("Inscripción solicitada correctamente. Estado: " + inscripcion.getEstado());
    }

    //Ver lista de inscritos (solo Admin/Club)
    @Operation(
            summary = "Ver inscritos por competición",
            description = "Rol ADMIN o CLUB. Muestra el listado de los deportistas apuntados en un torneo",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping("/competicion/{competicionId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'CLUB')")
    public ResponseEntity<List<InscripcionResponse>> verInscritos(@PathVariable Long competicionId){
            return ResponseEntity.ok(inscripcionService.listarPorCompeticion(competicionId));
    }

    //Actualizar estado (Aceptar/Rechazar)
    @Operation(
            summary = "Actualizar estado de la inscripción",
            description = "Rol ADMIN o CLUB. Permite ACEPTAR, RECHAZAR o CANCELAR una inscripción",
            security = @SecurityRequirement(name="bearerAuth")
    )
    @PatchMapping("/{id}/estado")
    @PreAuthorize("hasAnyRole('ADMIN', 'CLUB')")
    public ResponseEntity<?> actualizarEstado(
            @PathVariable Long id,
            @RequestBody CambioEstadoInscripcionRequest request) {
            var response = inscripcionService.cambiarEstado(id, request);
            return ResponseEntity.ok(response);
    }
}
