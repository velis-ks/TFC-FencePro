package com.fencepro.backend.controller;

import com.fencepro.backend.dto.RegistroDeportistaRequest;
import com.fencepro.backend.dto.response.DeportistaPerfilResponse;
import com.fencepro.backend.service.DeportistaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deportistas")
@RequiredArgsConstructor
@Tag(name= "Deportistas", description = "Gestión rol DEPORTISTA")
public class DeportistaController {

    private final DeportistaService deportistaService;

    @PostMapping("/registro")
    @Operation(summary = "Alta deportista", description = "Creación de usuario y ficha de deportista")
    public ResponseEntity<?> registrar(@Valid @RequestBody RegistroDeportistaRequest request) {

        var deportista = deportistaService.registrarDeportista(request);
        return ResponseEntity.ok("Deportista creado correctamente. ID: " +deportista.getId());
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'CLUB')")
    public ResponseEntity<List<DeportistaPerfilResponse>> listarDeportistas() {
        return ResponseEntity.ok(deportistaService.listarTodos());
    }
}