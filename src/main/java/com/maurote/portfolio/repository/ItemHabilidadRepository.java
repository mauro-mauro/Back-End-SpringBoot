package com.maurote.portfolio.repository;

import com.maurote.portfolio.entity.ItemHabilidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemHabilidadRepository extends JpaRepository<ItemHabilidad, Long>{
    
}
