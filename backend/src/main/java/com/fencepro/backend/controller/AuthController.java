package com.fencepro.backend.controller;

import com.fencepro.backend.service.AuthService;
import com.fencepro.model.enums.Rol;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth") // AÑADIDO /api AQUÍ
@RequiredArgsConstructor
@Tag(name = "Autenticación", description = "LOGIN y REGISTRO de usuarios")
public class AuthController {

    private final AuthService authService;

    public record LoginRequest(String email, String password) {}
    public record RegisterRequest(String nombre, String apellidos, String email, String password, Rol rol) {}

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(
                request.nombre(),
                request.apellidos(),
                request.email(),
                request.password(),
                request.rol()
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request.email(), request.password()));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(){
        return ResponseEntity.ok(Map.of("message", "Logout OK"));
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication authentication) {
        return ResponseEntity.ok(Map.of(
                "username", authentication.getName(),
                "authorities", authentication.getAuthorities()
        ));
    }
}