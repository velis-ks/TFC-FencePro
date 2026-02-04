package com.fencepro.backend.service;

import com.fencepro.backend.dto.RegistroClubRequest;
import com.fencepro.model.entity.Club;
import com.fencepro.model.entity.Usuario;
import com.fencepro.model.enums.Rol;
import com.fencepro.repository.ClubRepository;
import com.fencepro.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClubService {

    private final UsuarioRepository usuarioRepository;
    private final ClubRepository clubRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Club registrarClub(RegistroClubRequest request){
        //Validaciones
        if(usuarioRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("El email de usuario ya está registrado");
        }

        if(clubRepository.findByCif(request.getCif()).isPresent()){
            throw new RuntimeException("Ya existe un club con este CIF: " + request.getCif());
        }

        //Creación usuario
        Usuario usuario = Usuario.builder()
                .nombre(request.getNombre())
                .apellidos(request.getApellidos())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .rol(Rol.CLUB)
                .telefono(request.getTelefono())
                .activo(true)
                .emailVerificado(false)
                .build();

        usuario = usuarioRepository.save(usuario);

        //Creación ficha club
        Club club = new Club();

        club.setUsuario(usuario);
        club.setNombreClub(request.getNombreClub());
        club.setCif(request.getCif());
        club.setDireccion(request.getDireccion());
        club.setCiudad(request.getCiudad());
        club.setProvincia(request.getProvincia());
        club.setCodigoPostal(request.getCodigoPostal());
        club.setPresidente(request.getPresidente());
        club.setEmailClub(request.getEmailClub());
        club.setTelefonoClub(request.getTelefonoClub());
        club.setFechaFundacion(request.getFechaFundacion());

        return clubRepository.save(club);
    }
}
