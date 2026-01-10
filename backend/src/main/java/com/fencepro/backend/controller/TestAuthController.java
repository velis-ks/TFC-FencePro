package com.fencepro.backend.controller;

import com.fencepro.backend.security.jwt.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class TestAuthController {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public TestAuthController(JwtService jwtService,
                              UserDetailsService userDetailsService,
                              PasswordEncoder passwordEncoder) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    public record LoginRequest(String username, String password) { }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        UserDetails user = userDetailsService.loadUserByUsername(request.username());

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new BadCredentialsException("Credenciales incorrectas");
        }

        String token = jwtService.generateToken(user.getUsername());

        return ResponseEntity.ok(Map.of("token", token));
    }

    @GetMapping("/private")
    public ResponseEntity<?> privateEndPoint(){
        return ResponseEntity.ok(Map.of("message", "Has entrado con JWT válido"));
    }
}
