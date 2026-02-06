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
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@Tag(name = "Usuarios", description = "Gestion DATOS usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Operation(
            summary = "Obtener datos por rol",
            description = "Devuelve los datos del usuario logueado. Ej: Club --> datos fiscales",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @GetMapping("/perfil")
    public ResponseEntity<?> obtenerMiPerfil() {
        //1. Quién hace la petición desde el Token
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
            //2. Buscar los datos inteligentes
            Object perfil = usuarioService.obtenerPerfilInteligente(email);
            return ResponseEntity.ok(perfil);
    }
}
