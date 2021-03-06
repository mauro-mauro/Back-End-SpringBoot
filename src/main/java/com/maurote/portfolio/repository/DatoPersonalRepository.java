package com.maurote.portfolio.repository;

import com.maurote.portfolio.entity.DatoPersonal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatoPersonalRepository extends JpaRepository<DatoPersonal, Long>{    
}
