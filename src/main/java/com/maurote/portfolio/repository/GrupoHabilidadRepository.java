package com.maurote.portfolio.repository;

import java.util.List;
import java.util.Optional;

import com.maurote.portfolio.entity.GrupoHabilidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoHabilidadRepository extends JpaRepository<GrupoHabilidad, Long>{    
    Optional<GrupoHabilidad> findByGrupoHabilidadContaining(String nombre);
}
