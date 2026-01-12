package com.fencepro.repository;

import com.fencepro.model.entity.Competicion;
import com.fencepro.model.enums.EstadoCompeticion;
import com.fencepro.model.enums.Arma;
import com.fencepro.model.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CompeticionRepository extends JpaRepository<Competicion, Long> {

    // Ver competiciones activas (ABIERTA o EN_CURSO)
    List<Competicion> findByEstado(EstadoCompeticion estado);

    // Buscar torneos por Arma y Categoría (filtros típicos)
    List<Competicion> findByArmaAndCategoria(Arma arma, Categoria categoria);

    // Buscar competiciones en un rango de fechas (Calendario)
    List<Competicion> findByFechaInicioBetween(LocalDate start, LocalDate end);

    // Ordenar todas las competiciones por fecha (más recientes primero)
    List<Competicion> findAllByOrderByFechaInicioDesc();
}