package com.fencepro.backend.controller;

import com.fencepro.backend.dto.RegistroEntrenadorRequest;
import com.fencepro.backend.dto.response.DeportistaPerfilResponse;
import com.fencepro.backend.dto.response.EntrenadorPerfilResponse;
import com.fencepro.backend.service.EntrenadorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
@RequiredArgsConstructor

public class EntrenadorController {
    private final EntrenadorService entrenadorService;

    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@Valid @RequestBody RegistroEntrenadorRequest request){
            var entrenador = entrenadorService.registrarEntrenador(request);
            return ResponseEntity.ok("Entrenador registrado con éxito. ID: " + entrenador.getId());
    }

    @GetMapping
    public ResponseEntity<List<EntrenadorPerfilResponse>> listarEntrenadores() {
            return ResponseEntity.ok(entrenadorService.listarTodos());
    }
}
