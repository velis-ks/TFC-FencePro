package com.fencepro.backend.service;

import com.fencepro.backend.dto.CambioEstadoInscripcionRequest;
import com.fencepro.backend.dto.SolicitudInscripcionRequest;
import com.fencepro.backend.dto.response.InscripcionResponse;
import com.fencepro.model.entity.*;
import com.fencepro.model.enums.*;
import com.fencepro.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    //Mostrar listado de todos los inscritos en un torneo
    public List<InscripcionResponse> listarPorCompeticion (Long competicionId) {
        return inscripcionRepository.findByCompeticionId(competicionId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    //Cambiar estado de las inscripciones (Confirmación o cancelación)
    @Transactional
    public InscripcionResponse cambiarEstado(Long inscripcionId, CambioEstadoInscripcionRequest request){
        Inscripcion inscripcion = inscripcionRepository.findById(inscripcionId)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada"));

        EstadoInscripcion estadoEnum;
        try{
            estadoEnum = EstadoInscripcion.valueOf(request.getNuevoEstado().toUpperCase());
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Estado NO válido. Valores aceptados: PENDIENTE, CONFIRMADA, CANCELADA");
        }

        inscripcion.setEstado(estadoEnum);

        Inscripcion guardada = inscripcionRepository.save(inscripcion);
        return mapToResponse(guardada);
    }

    private InscripcionResponse mapToResponse(Inscripcion inscripcion){
        return InscripcionResponse.builder()
                .id(inscripcion.getId())
                .nombreDeportista(inscripcion.getDeportista().getUsuario().getNombre())
                .apellidosDeportista(inscripcion.getDeportista().getUsuario().getApellidos())
                .emailDeportista(inscripcion.getDeportista().getUsuario().getEmail())
                .nombreCompeticion(inscripcion.getCompeticion().getNombre())
                .estado(inscripcion.getEstado().name())
                .fechaInscripcion(inscripcion.getFechaInscripcion())
                .build();
    }
}
