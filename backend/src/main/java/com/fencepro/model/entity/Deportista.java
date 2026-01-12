package com.fencepro.model.entity;

import com.fencepro.model.enums.Arma;
import com.fencepro.model.enums.Categoria;
import com.fencepro.model.enums.NivelTecnico;
import com.fencepro.model.enums.Genero;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa un deportista de esgrima
 */
@Entity
@Table(name = "deportistas", indexes = {
        @Index(name = "idx_dni", columnList = "dni"),
        @Index(name = "idx_club", columnList = "club_id"),
        @Index(name = "idx_categoria", columnList = "categoria"),
        @Index(name = "idx_arma", columnList = "arma_principal")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"registrosSalud", "asistencias", "inscripciones"})
@EqualsAndHashCode(exclude = {"registrosSalud", "asistencias", "inscripciones"})
public class Deportista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El usuario es obligatorio")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    @NotBlank(message = "El DNI es obligatorio")
    @Column(unique = true, nullable = false, length = 20)
    private String dni;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @NotNull(message = "El sexo es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 1)
    private Genero genero;

    @Column(name = "foto_url", length = 255)
    private String fotoUrl;

    @NotNull(message = "La categoría es obligatoria")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

    @NotNull(message = "El nivel técnico es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_tecnico", nullable = false)
    private NivelTecnico nivelTecnico;

    @NotNull(message = "El arma principal es obligatoria")
    @Enumerated(EnumType.STRING)
    @Column(name = "arma_principal", nullable = false)
    private Arma armaPrincipal;

    @Column(name = "contacto_emergencia", length = 150)
    private String contactoEmergencia;

    @Column(name = "telefono_emergencia", length = 20)
    private String telefonoEmergencia;

    @Column(name = "grupo_sanguineo", length = 5)
    private String grupoSanguineo;

    @Column(columnDefinition = "TEXT")
    private String alergias;

    @Column(columnDefinition = "TEXT")
    private String lesiones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

    // Relaciones
    @OneToMany(mappedBy = "deportista", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<RegistroSalud> registrosSalud = new ArrayList<>();

    @OneToMany(mappedBy = "deportista", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Asistencia> asistencias = new ArrayList<>();

    @OneToMany(mappedBy = "deportista", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<Inscripcion> inscripciones = new ArrayList<>();

    /**
     * Calcula la edad del deportista
     */
    public int getEdad() {
        if (fechaNacimiento == null) {
            return 0;
        }
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    /**
     * Actualiza la categoría según la edad actual
     */
    public void actualizarCategoria() {
        this.categoria = Categoria.fromEdad(getEdad());
    }

    /**
     * Obtiene el nombre completo del deportista
     */
    public String getNombreCompleto() {
        return usuario != null ? usuario.getNombreCompleto() : "";
    }

    /**
     * Verifica si tiene alergias registradas
     */
    public boolean tieneAlergias() {
        return alergias != null && !alergias.trim().isEmpty();
    }

    /**
     * Verifica si tiene lesiones registradas
     */
    public boolean tieneLesiones() {
        return lesiones != null && !lesiones.trim().isEmpty();
    }

    /**
     * Verifica si pertenece a un club
     */
    public boolean tieneClub() {
        return club != null;
    }
}
