package com.fencepro.repository;

import com.fencepro.model.entity.Inscripcion;
import com.fencepro.model.enums.EstadoInscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    // Ver todas las inscripciones de UN deportista (Mi historial)
    List<Inscripcion> findByDeportistaId(Long deportistaId);

    // Ver todos los inscritos a UNA competición (Lista de salida)
    List<Inscripcion> findByCompeticionId(Long competicionId);

    // Filtrar inscritos por estado en un torneo (ej: solo los CONFIRMADOS)
    List<Inscripcion> findByCompeticionIdAndEstado(Long competicionId, EstadoInscripcion estado);

    // Vital para evitar duplicados: ¿Ya está inscrito este deportista en este torneo?
    boolean existsByDeportistaIdAndCompeticionId(Long deportistaId, Long competicionId);

    // Buscar la inscripción concreta para poder borrarla o editarla
    Optional<Inscripcion> findByDeportistaIdAndCompeticionId(Long deportistaId, Long competicionId);
}