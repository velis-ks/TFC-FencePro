package com.fencepro.repository;

import com.fencepro.model.entity.Entrenamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EntrenamientoRepository extends JpaRepository<Entrenamiento, Long> {

    // Clases de un club específico
    List<Entrenamiento> findByClubId(Long clubId);

    // Clases que imparte un entrenador
    List<Entrenamiento> findByEntrenadorId(Long entrenadorId);

    // Clases de una fecha concreta (Agenda diaria)
    List<Entrenamiento> findByFecha(LocalDate fecha);

    // Clases futuras (a partir de hoy) ordenadas
    List<Entrenamiento> findByFechaGreaterThanEqualOrderByFechaAsc(LocalDate fecha);
}