package com.fencepro.backend.controller;

import com.fencepro.backend.dto.RegistroArbitroRequest;
import com.fencepro.backend.dto.response.ArbitroPerfilResponse;
import com.fencepro.backend.dto.response.DeportistaPerfilResponse;
import com.fencepro.backend.service.ArbitroService;
import com.fencepro.model.entity.Arbitro;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/arbitros")
@RequiredArgsConstructor
@Tag(name = "Árbitros", description = "Gestión rol ÁRBITRO")
public class ArbitroController {
    private final ArbitroService arbitroService;

    @Operation(summary = "Registrar nuevo árbitro", description = "Crear usuario ÁRBITRO y registro de nivel y tipo de licencia")
    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@Valid @RequestBody RegistroArbitroRequest request) {
            var arbitro = arbitroService.registrarArbitro(request);
            return ResponseEntity.ok("Árbitro registrado con éxito. ID: "  + arbitro.getId());
    }

    @Operation(summary = "Ver todos los árbitros", description = "Devuelve lista completa de todos los árbitros y su nivel de la base de datos")
    @GetMapping
    public ResponseEntity<List<ArbitroPerfilResponse>> listarArbitros() {
            return ResponseEntity.ok(arbitroService.listarTodos());
    }
}
