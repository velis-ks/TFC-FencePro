package com.fencepro.backend.controller;

import com.fencepro.backend.dto.RegistroClubRequest;
import com.fencepro.backend.dto.response.ClubPerfilResponse;
import com.fencepro.backend.service.ClubService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clubes")
@RequiredArgsConstructor
@Tag(name = "Clubes", description = "Gestión rol CLUB")
public class ClubController {
    private final ClubService clubService;

    @Operation(summary = "Registro de nuevo club", description = "Creación de usuario y ficha de club")
    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@Valid @RequestBody RegistroClubRequest request){
            var club = clubService.registrarClub(request);
            return ResponseEntity.ok("Club registrado con éxito. ID: " +  club.getId() + " | Nombre: " + club.getNombreClub());
    }

    @Operation(summary = "Ver todos los clubes", description = "Devuelve lista completa de los clubes registrados en la base de datos")
    @GetMapping
    public ResponseEntity<List<ClubPerfilResponse>> listarClubes() {
            return ResponseEntity.ok(clubService.listarTodos());
    }
}
