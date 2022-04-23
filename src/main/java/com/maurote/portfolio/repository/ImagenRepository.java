package com.maurote.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.maurote.portfolio.entity.Imagen;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
    List<Imagen> findByOrderById();
}
