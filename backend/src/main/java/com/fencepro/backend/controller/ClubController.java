package com.fencepro.backend.controller;

import com.fencepro.backend.dto.RegistroClubRequest;
import com.fencepro.backend.service.ClubService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clubes")
@RequiredArgsConstructor

public class ClubController {
    private final ClubService clubService;

    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@Valid @RequestBody RegistroClubRequest request){
        try{
            var club = clubService.registrarClub(request);
            return ResponseEntity.ok("Club registrado con éxito. ID: " +  club.getId() + " | Nombre: " + club.getNombreClub());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error en el registro: " + e.getMessage());
        }
    }
}
