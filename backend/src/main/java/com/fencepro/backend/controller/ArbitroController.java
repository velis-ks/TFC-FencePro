package com.fencepro.backend.controller;

import com.fencepro.backend.dto.RegistroArbitroRequest;
import com.fencepro.backend.dto.response.ArbitroPerfilResponse;
import com.fencepro.backend.dto.response.DeportistaPerfilResponse;
import com.fencepro.backend.service.ArbitroService;
import com.fencepro.model.entity.Arbitro;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ArbitroPerfilResponse>> listarArbitros() {
        try {
            List<ArbitroPerfilResponse> lista = arbitroService.listarTodos();
            return ResponseEntity.ok(lista);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
