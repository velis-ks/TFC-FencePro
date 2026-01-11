package com.fencepro.backend.controller;
import com.fencepro.backend.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    public record LoginRequest(String username, String password) { }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request.username(), request.password()));
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication authentication) {
        return ResponseEntity.ok(Map.of("username", authentication.getName(), "authorities", authentication.getAuthorities()));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(){
        return ResponseEntity.ok(Map.of("message", "Logout OK"));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin-only")
    public ResponseEntity<?> adminOnly(){
        return ResponseEntity.ok(Map.of("message", "Admin Only"));
    }

    @PreAuthorize("hasRole('ENTRENADOR')")
    @GetMapping("/entrenador-only")
    public ResponseEntity<?> entrenadorOnly(){
        return ResponseEntity.ok(Map.of("message", "Entrenador Only"));
    }

    @PreAuthorize("hasRole('DEPORTISTA')")
    @GetMapping("deportista-only")
    public ResponseEntity<?> userOnly(){
        return ResponseEntity.ok(Map.of("message", "Deportista Only"));
    }

    @PreAuthorize("hasRole('ARBITRO')")
    @GetMapping("arbitro-only")
    public ResponseEntity<?> arbitroOnly(){
        return ResponseEntity.ok(Map.of("message", "Deportista Only"));
    }
}
