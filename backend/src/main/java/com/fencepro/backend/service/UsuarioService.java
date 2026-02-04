package com.fencepro.backend.service;

import com.fencepro.backend.dto.response.ArbitroPerfilResponse;
import com.fencepro.backend.dto.response.ClubPerfilResponse;
import com.fencepro.backend.dto.response.DeportistaPerfilResponse;
import com.fencepro.backend.dto.response.EntrenadorPerfilResponse;
import com.fencepro.model.entity.*;
import com.fencepro.model.enums.Rol;
import com.fencepro.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final DeportistaRepository deportistaRepository;
    private final EntrenadorRepository entrenadorRepository;
    private final ClubRepository clubRepository;
    private final ArbitroRepository arbitroRepository;

    //Mostrar objeto según perfil
    public Object obtenerPerfilInteligente(String email){
        //1. Buscar el usuario base (Login)
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        //2. En caso de ROL
        switch (usuario.getRol()){
            case DEPORTISTA:
                Deportista deportista = deportistaRepository.findByUsuarioId(usuario.getId())
                        .orElseThrow(() -> new RuntimeException("Deportista no encontrado en la base de datos"));

                String clubName = (deportista.getClub() != null) ? deportista.getClub().getNombreClub() : "Independiente";

                return DeportistaPerfilResponse.builder()
                        .id(deportista.getId())
                        .nombre(usuario.getNombre())
                        .apellidos(usuario.getApellidos())
                        .email(usuario.getEmail())
                        .dni(deportista.getDni())
                        .arma(deportista.getArmaPrincipal().name())
                        .categoria(deportista.getCategoria().name())
                        .nivelTecnico(deportista.getNivelTecnico().name())
                        .nombreClub(clubName)
                        .fechaNacimiento(deportista.getFechaNacimiento())
                        .rol(Rol.DEPORTISTA.name())
                        .build();

            case ENTRENADOR:
                Entrenador entrenador = entrenadorRepository.findByUsuarioId(usuario.getId())
                        .orElseThrow(() -> new RuntimeException("Entrenador no encontrado en la base de datos"));

                return EntrenadorPerfilResponse.builder()
                        .id(entrenador.getId())
                        .nombre(usuario.getNombre())
                        .apellidos(usuario.getApellidos())
                        .email(usuario.getEmail())
                        .dni(entrenador.getDni())
                        .especialidad(entrenador.getEspecialidad().name())
                        .titulacion(entrenador.getTitulacion())
                        .anosExperiencia(entrenador.getAnosExperiencia())
                        .numeroLicencia(entrenador.getNumeroLicencia())
                        .rol(Rol.ENTRENADOR.name())
                        .build();
            case CLUB:
                Club club = clubRepository.findByUsuarioId(usuario.getId())
                        .orElseThrow(() -> new RuntimeException("Club no encontrado en la base de datos"));

                return ClubPerfilResponse.builder()
                        .id(club.getId())
                        .nombreResponsable(usuario.getNombre() + " " + usuario.getApellidos())
                        .emailLogin(usuario.getEmail())
                        .nombreClub(club.getNombreClub())
                        .cif(club.getCif())
                        .ciudad(club.getCiudad())
                        .emailPublico(club.getEmailClub())
                        .rol(Rol.CLUB.name())
                        .build();

            case ARBITRO:
                Arbitro arbitro = arbitroRepository.findByUsuarioId(usuario.getId())
                        .orElseThrow(() -> new RuntimeException("Ficha de ábitro no encontrada en la base de datos"));
                return ArbitroPerfilResponse.builder()
                        .id(arbitro.getId())
                        .nombre(usuario.getNombre())
                        .apellidos(usuario.getApellidos())
                        .email(usuario.getEmail())
                        .nivel(arbitro.getNivel().name())
                        .numeroLicencia(arbitro.getNumeroLicencia())
                        .competicionesArbitradas(arbitro.getCompeticionesArbitradas())
                        .rol(Rol.ARBITRO.name())
                        .build();

            case ADMIN:
                return usuario;

            default:
                throw new RuntimeException("No existe un usuario en la base de datos");

        }
    }
}
