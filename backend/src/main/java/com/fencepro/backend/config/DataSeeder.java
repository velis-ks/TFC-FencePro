package com.fencepro.backend.config;

import com.fencepro.model.entity.Usuario;
import com.fencepro.model.enums.Rol;
import com.fencepro.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        String emailAdmin = "admin1@fencepro.com";

        // Si el admin ya existe (del script SQL o ejecuciones previas), lo quitamos
        // para volver a crearlo con la contraseña bien hasheada.
        var posibleAdmin = usuarioRepository.findByEmail(emailAdmin);
        if (posibleAdmin.isPresent()) {
            usuarioRepository.delete(posibleAdmin.get());
            usuarioRepository.flush();
        }

        // Creamos el usuario Admin desde cero
        Usuario admin = Usuario.builder()
                .nombre("Super Admin")
                .apellidos("Sistema")
                .email(emailAdmin)
                .password(passwordEncoder.encode("admin1234"))
                .rol(Rol.ADMIN)
                .telefono("600000001")
                .activo(true)
                .emailVerificado(true)
                .build();

        usuarioRepository.save(admin);

        System.out.println(">>> DataSeeder: Usuario Admin restablecido correctamente.");
    }
}