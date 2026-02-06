package com.fencepro.backend.controller;

import com.fencepro.backend.dto.RegistroEntrenadorRequest;
import com.fencepro.backend.dto.response.DeportistaPerfilResponse;
import com.fencepro.backend.dto.response.EntrenadorPerfilResponse;
import com.fencepro.backend.service.EntrenadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
@RequiredArgsConstructor
@Tag(name = "Entrenadores", description = "Gestión rol ENTRENADOR")
public class EntrenadorController {
    private final EntrenadorService entrenadorService;

    @Operation(summary = "Registrar nuevo entrenador", description = "Crea usuario entrenador + registro especialidad y titulación")
    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@Valid @RequestBody RegistroEntrenadorRequest request){
            var entrenador = entrenadorService.registrarEntrenador(request);
            return ResponseEntity.ok("Entrenador registrado con éxito. ID: " + entrenador.getId());
    }

    @Operation(summary = "Ver todos los entrenadores", description = "Devuelve lista completa de todos los entrenadores registrados en la base de datos")
    @GetMapping
    public ResponseEntity<List<EntrenadorPerfilResponse>> listarEntrenadores() {
            return ResponseEntity.ok(entrenadorService.listarTodos());
    }
}
