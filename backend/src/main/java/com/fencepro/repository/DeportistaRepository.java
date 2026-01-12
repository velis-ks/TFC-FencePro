package com.fencepro.repository;

import com.fencepro.model.entity.Deportista;
import com.fencepro.model.enums.Categoria;
import com.fencepro.model.enums.Arma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeportistaRepository extends JpaRepository<Deportista, Long> {

    // Buscar perfil deportivo por el ID de usuario (Login)
    Optional<Deportista> findByUsuarioId(Long usuarioId);

    // Búsqueda exacta por DNI
    Optional<Deportista> findByDni(String dni);

    // Listar todos los deportistas de un club concreto
    List<Deportista> findByClubId(Long clubId);

    // Filtrar por categoría y arma (ej: ver todos los M15 de SABLE)
    List<Deportista> findByCategoriaAndArmaPrincipal(Categoria categoria, Arma arma);
}