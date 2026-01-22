package com.fencepro.backend.service;

import com.fencepro.backend.security.jwt.JwtService;
import com.fencepro.model.entity.Usuario;
import com.fencepro.model.enums.Rol;
import com.fencepro.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // Registro usuario
    public Map<String, Object> register(String nombre, String email, String password, Rol rol) {
        if (usuarioRepository.existsByEmail(email)) {
            throw new RuntimeException("Este email ya existe");
        }

        // Construimos el usuario
        var usuario = Usuario.builder()
                .nombre(nombre)
                .apellidos("")
                .email(email)
                .password(passwordEncoder.encode(password)) //Encriptación de contraseña
                .rol(rol)
                .activo(true)
                .build();

        usuarioRepository.save(usuario);
        String token = jwtService.generateToken(usuario.getUsername());


        return Map.of("token", token, "rol", rol);
    }

    // Login usuario
    public Map<String, Object> login(String email, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        var usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        String token = jwtService.generateToken(usuario.getUsername());

        return Map.of("token", token, "rol", usuario.getRol());
    }
}