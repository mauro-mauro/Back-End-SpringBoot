package com.maurote.portfolio.service;

import java.util.List;
import java.util.Optional;

import com.maurote.portfolio.entity.GrupoHabilidad;

import org.springframework.data.jpa.repository.Query;

public interface IGrupoHabilidadService {
    public List<GrupoHabilidad> listarGrupoHabilidad();
    public void agregarGrupoHabilidad(GrupoHabilidad grupoHab);
    public void borrarGrupoHabilidadPorId(Long id);
    public void borrarGrupoHabilidadPorObjeto(GrupoHabilidad grupoHab);
    public boolean existePorId(Long id);
    public Optional<GrupoHabilidad> getOne(Long id);
    Optional<GrupoHabilidad> findByGrupoHabilidadContaining(String nombre);

}
