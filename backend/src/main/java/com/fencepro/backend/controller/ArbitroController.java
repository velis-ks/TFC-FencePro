package com.fencepro.backend.controller;

import com.fencepro.backend.dto.RegistroArbitroRequest;
import com.fencepro.backend.service.ArbitroService;
import com.fencepro.model.entity.Arbitro;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/arbitros")
@RequiredArgsConstructor

public class ArbitroController {
    private final ArbitroService arbitroService;

    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@Valid @RequestBody RegistroArbitroRequest request) {
        try{
            var arbitro = arbitroService.registrarArbitro(request);
            return ResponseEntity.ok("Árbitro registrado con éxito. ID: "  + arbitro.getId());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error en el registro: " + e.getMessage());
        }
    }
}
