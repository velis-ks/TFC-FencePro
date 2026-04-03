package com.fencepro.backend.controller;

import com.fencepro.backend.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios") // AÑADIDO /api AQUÍ
@RequiredArgsConstructor
@Tag(name = "Usuarios", description = "Gestion DATOS usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping("/perfil")
    public ResponseEntity<?> obtenerMiPerfil() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        return ResponseEntity.ok(usuarioService.obtenerPerfilInteligente(email));
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodosLosUsuarios() {
        return ResponseEntity.ok(usuarioService.obtenerTodos());
    }
}