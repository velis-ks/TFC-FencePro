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
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Autenticación", description = "Login y registro de usuarios")
public class AuthController {

    private final AuthService authService;

    public record LoginRequest(String email, String password) {}
    public record RegisterRequest(String nombre, String email, String password, Rol rol) {}

    @Operation(summary = "Registrar nuevo usuario", description = "Creación de nuevos usuarios + token JWT. No permite crear ADMINs")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(
                request.nombre(), request.email(), request.password(), request.rol()
        ));
    }

    @Operation(summary = "Iniciar sesión", description = "Valida credenciales y devuelve JWT + Rol")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request.email(), request.password()));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(){
        return ResponseEntity.ok(Map.of("message", "Logout OK (Borrar token en cliente)"));
    }

    //Endpoints de prueba

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/me")
    public ResponseEntity<?> me(Authentication authentication) {
        return ResponseEntity.ok(Map.of(
                "username", authentication.getName(),
                "authorities", authentication.getAuthorities()
        ));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin-only")
    public ResponseEntity<?> adminOnly(){
        return ResponseEntity.ok(Map.of("message", "Zona Admin: Acceso concedido"));
    }

    @PreAuthorize("hasRole('ENTRENADOR')")
    @GetMapping("/entrenador-only")
    public ResponseEntity<?> entrenadorOnly(){
        return ResponseEntity.ok(Map.of("message", "Zona Entrenador: Acceso concedido"));
    }
}