package com.maurote.portfolio.repository;

import com.maurote.portfolio.entity.Plataforma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Long>{
    
}
