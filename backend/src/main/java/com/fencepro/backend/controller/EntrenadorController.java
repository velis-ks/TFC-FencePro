package com.fencepro.backend.controller;

import com.fencepro.backend.dto.RegistroEntrenadorRequest;
import com.fencepro.backend.service.EntrenadorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/entrenadores")
@RequiredArgsConstructor

public class EntrenadorController {
    private final EntrenadorService entrenadorService;

    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@Valid @RequestBody RegistroEntrenadorRequest request){
        try{
            var entrenador = entrenadorService.registrarEntrenador(request);
            return ResponseEntity.ok("Entrenador registrado con éxito. ID: " + entrenador.getId());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error durante el registro: " + e.getMessage());
        }
    }
}
