package com.fencepro.backend.controller;

import com.fencepro.backend.dto.RegistroClubRequest;
import com.fencepro.backend.dto.response.ClubPerfilResponse;
import com.fencepro.backend.service.ClubService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clubes")
@RequiredArgsConstructor

public class ClubController {
    private final ClubService clubService;

    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@Valid @RequestBody RegistroClubRequest request){
            var club = clubService.registrarClub(request);
            return ResponseEntity.ok("Club registrado con éxito. ID: " +  club.getId() + " | Nombre: " + club.getNombreClub());
    }

    @GetMapping
    public ResponseEntity<List<ClubPerfilResponse>> listarClubes() {
            return ResponseEntity.ok(clubService.listarTodos());
    }
}
