package com.fencepro.backend.service;

import com.fencepro.backend.dto.CrearCompeticionRequest;
import com.fencepro.backend.dto.response.CompeticionResponse;
import com.fencepro.model.entity.Arbitro;
import com.fencepro.model.entity.Competicion;
import com.fencepro.model.enums.Arma;
import com.fencepro.model.enums.Categoria;
import com.fencepro.model.enums.EstadoCompeticion;
import com.fencepro.model.enums.NivelCompeticion;
import com.fencepro.repository.ArbitroRepository;
import com.fencepro.repository.CompeticionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompeticionService {
    private final CompeticionRepository competicionRepository;
    private final ArbitroRepository arbitroRepository;

    @Transactional
    public Competicion crearCompeticion(CrearCompeticionRequest request){
        //Validaciones
        if(request.getFechaFin().isBefore(request.getFechaInicio())){
            throw new RuntimeException("La fecha de fin no puede ser anterior a la del inicio de la competición");
        }

        //Enums
        Arma arma;
        Categoria categoria;
        NivelCompeticion nivel;

        try{
            arma = Arma.valueOf(request.getArma().toUpperCase());
            categoria = Categoria.valueOf(request.getCategoria().toUpperCase());
            nivel = NivelCompeticion.valueOf(request.getNivel().toUpperCase());
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Error en los valores de Arma, Categoría o Nivel");
        }

        //Buscar árbitro
        Arbitro arbitro = null;
        if(request.getArbitroId() != null){
            arbitro = arbitroRepository.findById(request.getArbitroId())
                    .orElseThrow(() -> new RuntimeException("Árbitro no encontrado con ID: " + request.getArbitroId()));
        }

        //Crear competición --> ENTIDAD
        Competicion competicion = new Competicion();
        competicion.setNombre(request.getNombre());
        competicion.setDescripcion(request.getDescripcion());
        competicion.setFechaInicio(request.getFechaInicio());
        competicion.setFechaFin(request.getFechaFin());
        competicion.setUbicacion(request.getUbicacion());
        competicion.setArma(arma);
        competicion.setCategoria(categoria);
        competicion.setNivel(nivel);
        competicion.setCapacidadMaxima(request.getCapacidadMaxima());
        competicion.setPrecioInscripcion(request.getPrecioInscripcion());

        //Por defecto la competición se crea abierta
        competicion.setEstado(EstadoCompeticion.ABIERTA);
        competicion.setArbitro(arbitro);

        return competicionRepository.save(competicion);
    }

    public List<CompeticionResponse> listarTodas(){
        return competicionRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private CompeticionResponse mapToResponse(Competicion competicion){
        return CompeticionResponse.builder()
                .id(competicion.getId())
                .nombre(competicion.getNombre())
                .descripcion(competicion.getDescripcion())
                .fechaInicio(competicion.getFechaInicio())
                .fechaFin(competicion.getFechaFin())
                .ubicacion(competicion.getUbicacion())
                .arma(competicion.getArma().name())
                .categoria(competicion.getCategoria().name())
                .nivel(competicion.getNivel().name())
                .estado(competicion.getEstado().name())
                .capacidadMaxima(competicion.getCapacidadMaxima())
                .inscritosActuales(0) //TODO: Implementar cálculo
                .precioInscripcion(competicion.getPrecioInscripcion())
                .build();
    }
}
