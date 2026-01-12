package com.fencepro.repository;

import com.fencepro.model.entity.Pago;
import com.fencepro.model.enums.EstadoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    // Historial de pagos de un usuario
    List<Pago> findByUsuarioId(Long usuarioId);

    // Buscar pagos pendientes (para reclamar)
    List<Pago> findByEstado(EstadoPago estado);

    // Buscar por referencia única
    Optional<Pago> findByReferenciaPago(String referenciaPago);
}