package com.fencepro.backend.controller;

import com.fencepro.backend.dto.SolicitudInscripcionRequest;
import com.fencepro.backend.service.InscripcionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inscripciones")
@RequiredArgsConstructor
public class InscripcionController {

    private final InscripcionService inscripcionService;

    @PostMapping("/solicitar")
    @PreAuthorize("hasRole('DEPORTISTA')")
    public ResponseEntity<?> solicitarInscripcion(@Valid @RequestBody SolicitudInscripcionRequest request){
        //Quién se inscribe (TOKEN)
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        try{
            var inscripcion = inscripcionService.inscribirse(email, request);
            return ResponseEntity.ok("Inscripción solicitada correctamente. Estado: " + inscripcion.getEstado());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
