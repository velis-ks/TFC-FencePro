package com.fencepro.backend.service;

import com.fencepro.backend.dto.RegistroEntrenadorRequest;
import com.fencepro.backend.dto.response.DeportistaPerfilResponse;
import com.fencepro.backend.dto.response.EntrenadorPerfilResponse;
import com.fencepro.model.entity.Deportista;
import com.fencepro.model.entity.Entrenador;
import com.fencepro.model.entity.Usuario;
import com.fencepro.model.enums.Especialidad;
import com.fencepro.model.enums.Rol;
import com.fencepro.repository.EntrenadorRepository;
import com.fencepro.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class EntrenadorService {
    private final UsuarioRepository usuarioRepository;
    private final EntrenadorRepository entrenadorRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Entrenador registrarEntrenador(RegistroEntrenadorRequest request){
        //Validación email
        if (usuarioRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("El email " + request.getEmail() + " ya está registrado");
        }
        //Validación dni
        if (entrenadorRepository.findByDni(request.getDni()).isPresent()){
            throw new RuntimeException("El DNI " + request.getDni() + " ya existe en el sistema");
        }
        //Validación número de licencia
        if (request.getNumeroLicencia() != null && !request.getNumeroLicencia().isBlank()) {
            if(entrenadorRepository.findByNumeroLicencia(request.getNumeroLicencia()).isPresent()){
                throw new RuntimeException("El número de licencia ya está en uso");
            }
        }

        //Conversión manual enum
        Especialidad especialidad;
        try {
            especialidad = Especialidad.valueOf(request.getEspecialidad().toUpperCase());
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Valores permitidos: FLORETE, ESPADA, SABLE, TODAS");
        }

        //Creación de usuario (login)
        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .apellidos(request.getApellidos())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(Rol.ENTRENADOR)
                .telefono(request.getTelefono())
                .activo(true)
                .emailVerificado(false)
                .build();

        usuario = usuarioRepository.save(usuario);

        //Creación ficha de entrenador
        Entrenador entrenador = new Entrenador();
        entrenador.setUsuario(usuario);
        entrenador.setDni(request.getDni());
        entrenador.setFechaNacimiento(request.getFechaNacimiento());
        entrenador.setEspecialidad(especialidad);
        entrenador.setTitulacion(request.getTitulacion());
        entrenador.setNumeroLicencia(request.getNumeroLicencia());

        //Timestamp con la fecha de hoy
        entrenador.setFechaAlta(LocalDate.now());

        return entrenadorRepository.save(entrenador);

    }

    //Obtener la lista de todos los entrenadores
    public List<EntrenadorPerfilResponse> listarTodos(){
        return entrenadorRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    private EntrenadorPerfilResponse mapToResponse(Entrenador entrenador) {

        return EntrenadorPerfilResponse.builder()
                .id(entrenador.getId())
                .nombre(entrenador.getUsuario().getNombre())
                .apellidos(entrenador.getUsuario().getApellidos())
                .email(entrenador.getUsuario().getEmail())
                .dni(entrenador.getDni())
                .especialidad(entrenador.getEspecialidad().name())
                .titulacion(entrenador.getTitulacion())
                .anosExperiencia(entrenador.getAnosExperiencia())
                .numeroLicencia(entrenador.getNumeroLicencia())
                .rol(Rol.ENTRENADOR.name())
                .build();
    }
}
