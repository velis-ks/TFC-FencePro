package com.fencepro.backend.controller;

import com.fencepro.backend.dto.CrearCompeticionRequest;
import com.fencepro.backend.dto.response.CompeticionResponse;
import com.fencepro.backend.service.CompeticionService;
import com.fencepro.model.entity.Competicion;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competiciones")
@RequiredArgsConstructor
@Tag(name = "Competiciones", description = "Gestión COMPETICIONES y EVENTOS")
public class CompeticionController {
    private final CompeticionService competicionService;

    //Permisos exclusivos para ADMIN y CLUBES
    @Operation(
            summary = "Crear nueva competición",
            description = "Solo ADMIN o CLUB pueden crear un evento",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','CLUB')")
    public ResponseEntity<?> crearCompeticion(@Valid @RequestBody CrearCompeticionRequest request){
            var competicion = competicionService.crearCompeticion(request);
            return ResponseEntity.ok().body("Competición creada con éxito. ID: " + competicion.getId());
    }

    @Operation(summary = "Ver todas las competiciones", description = "Devuelve lista de todas las competiciones registradas en la base de datos")
    @GetMapping
    public ResponseEntity<List<CompeticionResponse>> listarCompeticiones(){
            return ResponseEntity.ok(competicionService.listarTodas());
    }
}
