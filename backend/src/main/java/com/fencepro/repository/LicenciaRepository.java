package com.fencepro.repository;

import com.fencepro.model.entity.Licencia;
import com.fencepro.model.enums.EstadoLicencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LicenciaRepository extends JpaRepository<Licencia, Long> {

    // Ver todas las licencias de un usuario
    List<Licencia> findByUsuarioId(Long usuarioId);

    // Buscar si tiene alguna licencia APROBADA (Vigente)
    Optional<Licencia> findByUsuarioIdAndEstado(Long usuarioId, EstadoLicencia estado);

    // Buscar licencias CADUCADAS (para avisar renovación)
    List<Licencia> findByEstado(EstadoLicencia estado);
}