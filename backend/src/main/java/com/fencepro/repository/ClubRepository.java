package com.fencepro.repository;

import com.fencepro.model.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

    // Buscar club por su usuario asociado
    Optional<Club> findByUsuarioId(Long usuarioId);

    // Buscar por CIF (para validaciones)
    Optional<Club> findByCif(String cif);

    // Buscar por nombre (búsqueda parcial, ignore mayúsculas)
    // Ej: "esgrima" encuentra "Club Esgrima Madrid"
    Optional<Club> findByNombreClubContainingIgnoreCase(String nombreClub);
}