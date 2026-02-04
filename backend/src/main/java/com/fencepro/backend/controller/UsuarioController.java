package com.fencepro.backend.controller;

import com.fencepro.backend.service.UsuarioService;
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
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping("/perfil")
    public ResponseEntity<?> obtenerMiPerfil() {
        //1. Quién hace la petición desde el Token
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        try{
            //2. Buscar los datos inteligentes
            Object perfil = usuarioService.obtenerPerfilInteligente(email);
            return ResponseEntity.ok(perfil);
        }catch(Exception e){
            return ResponseEntity.badRequest().body("No se puede recuperar el perfil: " + e.getMessage());
        }
    }
}
