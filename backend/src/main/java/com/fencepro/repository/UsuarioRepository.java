package com.fencepro.repository;

import com.fencepro.model.entity.Usuario;
import com.fencepro.model.enums.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Fundamental para el Login
    Optional<Usuario> findByEmail(String email);

    // Para evitar registros duplicados
    boolean existsByEmail(String email);

    // Listar usuarios por rol (ej: ver todos los ENTRENADORES)
    List<Usuario> findByRol(Rol rol);
}