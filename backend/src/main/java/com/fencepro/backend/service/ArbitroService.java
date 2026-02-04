package com.fencepro.backend.service;

import com.fencepro.backend.dto.RegistroArbitroRequest;
import com.fencepro.backend.dto.response.ArbitroPerfilResponse;
import com.fencepro.backend.dto.response.DeportistaPerfilResponse;
import com.fencepro.model.entity.Arbitro;
import com.fencepro.model.entity.Deportista;
import com.fencepro.model.entity.Usuario;
import com.fencepro.model.enums.NivelArbitro;
import com.fencepro.model.enums.NivelTecnico;
import com.fencepro.model.enums.Rol;
import com.fencepro.repository.ArbitroRepository;
import com.fencepro.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ArbitroService {
    private final UsuarioRepository usuarioRepository;
    private final ArbitroRepository arbitroRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Arbitro registrarArbitro(RegistroArbitroRequest request){
        //Validación email+dni
        if(usuarioRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("El email ya está registrado");
        }

        if(arbitroRepository.findByDni(request.getDni()).isPresent()){
            throw new RuntimeException("El DNI ya existe en el sistema");
        }

        //enum
        NivelArbitro nivel;
        try{
            nivel = NivelArbitro.valueOf(request.getNivel().toUpperCase());
        }catch(IllegalArgumentException e){
            throw new RuntimeException("Nivel no válidos. Valores admitidos: AUTONOMICO, NACIONAL, INTERNACIONAL");
        }

        //Creación usuario
        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .apellidos(request.getApellidos())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(Rol.ARBITRO)
                .telefono(request.getTelefono())
                .activo(true)
                .emailVerificado(false)
                .build();

        usuario = usuarioRepository.save(usuario);

        //Ficha de árbitro
        Arbitro arbitro = new Arbitro();
        arbitro.setUsuario(usuario);
        arbitro.setDni(request.getDni());
        arbitro.setFechaNacimiento(request.getFechaNacimiento());
        arbitro.setNumeroLicencia(request.getNumeroLicencia());
        arbitro.setNivel(nivel);
        arbitro.setFechaCertificacion(LocalDate.now());
        arbitro.setCompeticionesArbitradas(0);

        return arbitroRepository.save(arbitro);
    }

    //Obtener la lista de todos los árbitros
    public List<ArbitroPerfilResponse> listarTodos(){
        return arbitroRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private ArbitroPerfilResponse mapToResponse(Arbitro arbitro) {
        return ArbitroPerfilResponse.builder()
                .id(arbitro.getId())
                .nombre(arbitro.getUsuario().getNombre())
                .apellidos(arbitro.getUsuario().getApellidos())
                .email(arbitro.getUsuario().getEmail())
                .nivel(arbitro.getNivel().name())
                .numeroLicencia(arbitro.getNumeroLicencia())
                .competicionesArbitradas(arbitro.getCompeticionesArbitradas())
                .rol(Rol.ARBITRO.name())
                .build();
    }
}
