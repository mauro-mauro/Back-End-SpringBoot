package com.maurote.portfolio.security.repository;

import java.util.*;

import com.maurote.portfolio.security.entity.Rol;
import com.maurote.portfolio.security.enums.RolNombre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
