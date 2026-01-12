package com.fencepro.repository;

import com.fencepro.model.entity.Arbitro;
import com.fencepro.model.enums.NivelArbitro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArbitroRepository extends JpaRepository<Arbitro, Long> {

    Optional<Arbitro> findByUsuarioId(Long usuarioId);
    Optional<Arbitro> findByDni(String dni);

    // Buscar árbitros de cierto nivel (ej: INTERNACIONAL)
    List<Arbitro> findByNivel(NivelArbitro nivel);
}