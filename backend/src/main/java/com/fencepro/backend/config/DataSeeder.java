package com.fencepro.backend.config;

import com.fencepro.model.entity.Usuario;
import com.fencepro.model.enums.Rol;
import com.fencepro.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.count() == 0) {
            Usuario admin = Usuario.builder()
                    .nombre("Super Admin")
                    .apellidos("Sistema")
                    .email("admin@fencepro.com")
                    .password(passwordEncoder.encode("admin1234"))
                    .rol(Rol.ADMIN)
                    .activo(true)
                    .emailVerificado(true)
                    .build();

            usuarioRepository.save(admin);
            System.out.println("Usuario ADMIN creado");
        }
    }
}