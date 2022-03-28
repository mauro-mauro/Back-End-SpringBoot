package com.maurote.portfolio.repository;

import com.maurote.portfolio.entity.Habilidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Long>{
    
}
