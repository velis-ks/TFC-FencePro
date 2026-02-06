package com.fencepro.backend.controller;

import com.fencepro.backend.dto.CrearCompeticionRequest;
import com.fencepro.backend.dto.response.CompeticionResponse;
import com.fencepro.backend.service.CompeticionService;
import com.fencepro.model.entity.Competicion;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competiciones")
@RequiredArgsConstructor

public class CompeticionController {
    private final CompeticionService competicionService;

    //Permisos exclusivos para ADMIN y CLUBES
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','CLUB')")
    public ResponseEntity<?> crearCompeticion(@Valid @RequestBody CrearCompeticionRequest request){
            var competicion = competicionService.crearCompeticion(request);
            return ResponseEntity.ok().body("Competición creada con éxito. ID: " + competicion.getId());
    }

    @GetMapping
    public ResponseEntity<List<CompeticionResponse>> listarCompeticiones(){
            return ResponseEntity.ok(competicionService.listarTodas());
    }
}
