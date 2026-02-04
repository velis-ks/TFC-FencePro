package com.fencepro.backend.controller;

import com.fencepro.backend.dto.CrearCompeticionRequest;
import com.fencepro.backend.service.CompeticionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/competiciones")
@RequiredArgsConstructor

public class CompeticionController {
    private final CompeticionService competicionService;

    //Permisos exclusivos para ADMIN y CLUBES
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','CLUB')")
    public ResponseEntity<?> crearCompeticion(@Valid @RequestBody CrearCompeticionRequest request){
        try{
            var competicion = competicionService.crearCompeticion(request);
            return ResponseEntity.ok().body("Competición creada con éxito. ID: " + competicion.getId());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error al crear competicion: " + e.getMessage());
        }
    }
}
