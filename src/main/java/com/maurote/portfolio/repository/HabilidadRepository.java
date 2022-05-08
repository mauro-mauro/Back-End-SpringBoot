package com.maurote.portfolio.repository;

import java.util.List;

import com.maurote.portfolio.entity.Habilidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Long>{
    //List<Habilidad> findByIdGrupoHabilidadContaining(long id);
    @Query(value = "SELECT * FROM habilidad WHERE habilidad.id_grupo_habilidad=:id", nativeQuery = true)
    List<Habilidad> search(@Param("id") Long id);
    @Modifying
    @Query(value = "DELETE FROM habilidad WHERE habilidad.id_grupo_habilidad=:idGrupoHabilidadBorrar", nativeQuery = true)
    void borrarConGrupoDeHabilidad(@Param("idGrupoHabilidadBorrar") Long idGrupoHabilidadBorrar);
}
