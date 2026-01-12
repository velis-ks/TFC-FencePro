package com.fencepro.repository;

import com.fencepro.model.entity.RegistroSalud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroSaludRepository extends JpaRepository<RegistroSalud, Long> {

    // Historial médico completo de un deportista (el más nuevo primero)
    List<RegistroSalud> findByDeportistaIdOrderByFechaRegistroDesc(Long deportistaId);
}