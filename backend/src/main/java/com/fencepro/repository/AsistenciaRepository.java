package com.fencepro.repository;

import com.fencepro.model.entity.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {

    // Lista de asistencia de una clase concreta
    List<Asistencia> findByEntrenamientoId(Long entrenamientoId);

    // Historial de asistencia de un deportista (¿cuánto ha entrenado?)
    List<Asistencia> findByDeportistaId(Long deportistaId);
}