package com.fencepro.backend.service;

import com.fencepro.backend.dto.SolicitudInscripcionRequest;
import com.fencepro.model.entity.*;
import com.fencepro.model.enums.*;
import com.fencepro.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InscripcionService {

    private final UsuarioRepository usuarioRepository;
    private final DeportistaRepository deportistaRepository;
    private final CompeticionRepository competicionRepository;
    private final InscripcionRepository inscripcionRepository;
    private final PagoRepository pagoRepository;

    @Transactional
    public Inscripcion inscribirse(String emailUsuario, SolicitudInscripcionRequest request){
        //Deportista
        Usuario usuario = usuarioRepository.findByEmail(emailUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Deportista deportista = deportistaRepository.findByUsuarioId(usuario.getId())
                .orElseThrow(() -> new RuntimeException("El deportista no está dado de alta"));

        Competicion competicion = competicionRepository.findById(request.getCompeticionId())
                .orElseThrow(() -> new RuntimeException("Competicion no encontrada"));

        //Validaciones
        if(competicion.getEstado() != EstadoCompeticion.ABIERTA) {
            throw new RuntimeException("El plazo de inscripción está cerrado");
        }

        if(inscripcionRepository.existsByDeportistaIdAndCompeticionId(deportista.getId(), competicion.getId())) {
            throw new RuntimeException("Ya estás inscrito en esta competición");
        }

        //Creación de inscripciones
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setDeportista(deportista);
        inscripcion.setCompeticion(competicion);
        inscripcion.setEstado(EstadoInscripcion.PENDIENTE); //Pendiente de pago o validación
        inscripcion.setFechaInscripcion(LocalDateTime.now());

        inscripcion = inscripcionRepository.save(inscripcion);

        //Pago PENDIENTE (automático)
        Pago pago = new Pago();
        pago.setUsuario(usuario);
        pago.setMonto(competicion.getPrecioInscripcion());
        pago.setConcepto(ConceptoPago.INSCRIPCION_COMPETICION);
        pago.setEstado(EstadoPago.PENDIENTE);
        pago.setMetodoPago(MetodoPago.TARJETA); //Por defecto
        pago.setDescripcion("Inscripción Torneo: " + competicion.getNombre());
        pago.setReferenciaPago("PAY-" + UUID.randomUUID().toString().substring(0,8).toUpperCase());

        pagoRepository.save(pago);

        return inscripcion;
    }
}
