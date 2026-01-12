package com.fencepro.repository;

import com.fencepro.model.entity.Entrenador;
import com.fencepro.model.enums.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {

    Optional<Entrenador> findByUsuarioId(Long usuarioId);
    Optional<Entrenador> findByDni(String dni);
    Optional<Entrenador> findByNumeroLicencia(String numeroLicencia);

    // Buscar entrenadores por especialidad (o que sepan TODAS)
    List<Entrenador> findByEspecialidad(Especialidad especialidad);
}