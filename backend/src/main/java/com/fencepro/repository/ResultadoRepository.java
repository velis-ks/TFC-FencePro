package com.fencepro.repository;

import com.fencepro.model.entity.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Long> {

    // Obtener la clasificación final de un torneo ordenada (1º, 2º, 3º...)
    List<Resultado> findByCompeticionIdOrderByPosicionAsc(Long competicionId);

    // Ver el resultado de una inscripción concreta
    Optional<Resultado> findByInscripcionId(Long inscripcionId);
}