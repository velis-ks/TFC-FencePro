package com.fencepro.backend.service;

import com.fencepro.backend.dto.RegistroDeportistaRequest;
import com.fencepro.model.entity.Deportista;
import com.fencepro.model.entity.Usuario;
import com.fencepro.model.enums.Arma;
import com.fencepro.model.enums.Categoria;
import com.fencepro.model.enums.NivelTecnico;
import com.fencepro.model.enums.Rol;
import com.fencepro.repository.DeportistaRepository;
import com.fencepro.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class DeportistaService {

    private final UsuarioRepository usuarioRepository;
    private final DeportistaRepository deportistaRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Deportista registrarDeportista(RegistroDeportistaRequest request) {

        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("El email " + request.getEmail() + " ya está registrado.");
        }
        if (deportistaRepository.findByDni(request.getDni()).isPresent()) {
            throw new RuntimeException("El DNI " + request.getDni() + " ya existe en el sistema.");
        }

        // Arma
        if (request.getArmaPrincipal() == null || request.getArmaPrincipal().isBlank()) {
            throw new IllegalArgumentException("El campo 'armaPrincipal' es obligatorio.");
        }
        Arma arma;
        try {
            arma = Arma.valueOf(request.getArmaPrincipal().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Arma no válida: " + request.getArmaPrincipal() +
                    ". Valores permitidos: FLORETE, ESPADA, SABLE.");
        }

        //Nivel Técnico
        NivelTecnico nivel = NivelTecnico.INICIACION;
        if (request.getNivelTecnico() != null && !request.getNivelTecnico().isBlank()) {
            try {
                nivel = NivelTecnico.valueOf(request.getNivelTecnico().toUpperCase());
            } catch (IllegalArgumentException e) {

                System.out.println("Nivel desconocido: " + request.getNivelTecnico() + ". Se asigna INICIACIÓN.");
            }
        }

        // 3. CREAR USUARIO (Login)
        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .apellidos(request.getApellidos())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(Rol.DEPORTISTA) //Rol forzado
                .telefono(request.getTelefono())
                .activo(true)
                .emailVerificado(false)
                .build();

        usuario = usuarioRepository.save(usuario); //Guardar usuario

        //Cálculo categoría de edad
        Categoria categoria = calcularCategoria(request.getFechaNacimiento());

        //Ficha deportista
        Deportista deportista = new Deportista();
        deportista.setUsuario(usuario);
        deportista.setDni(request.getDni());
        deportista.setFechaNacimiento(request.getFechaNacimiento());
        deportista.setGenero(request.getGenero());

        deportista.setArmaPrincipal(arma);
        deportista.setNivelTecnico(nivel);
        deportista.setCategoria(categoria);

        return deportistaRepository.save(deportista);
    }

    private Categoria calcularCategoria(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) return Categoria.ABS;
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        return Categoria.fromEdad(edad);
    }
}