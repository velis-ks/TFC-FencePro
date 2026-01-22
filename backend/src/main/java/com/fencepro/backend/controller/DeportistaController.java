package com.fencepro.backend.controller;

import com.fencepro.backend.dto.RegistroDeportistaRequest;
import com.fencepro.backend.service.DeportistaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/deportistas")
@RequiredArgsConstructor
public class DeportistaController {

    private final DeportistaService deportistaService;

    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@Valid @RequestBody RegistroDeportistaRequest request) {

        try {
            var deportista = deportistaService.registrarDeportista(request);

            return ResponseEntity.ok("Deportista creado con éxito. ID: " + deportista.getId() +
                    " | Categoría: " + deportista.getCategoria());

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el registro: " + e.getMessage());
        }
    }
}