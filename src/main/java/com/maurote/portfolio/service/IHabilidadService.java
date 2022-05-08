package com.maurote.portfolio.service;

import java.util.List;
import java.util.Optional;

import com.maurote.portfolio.entity.Habilidad;

public interface IHabilidadService {
    public List<Habilidad> listarHabilidad();
    public void agregarHabilidad(Habilidad itemHab);
    public void borrarHabilidad(Long id);
    public boolean existePorId(Long id);
    public Optional<Habilidad> getOne(Long id);

    public List<Habilidad> search(Long id);
    public void borrarConGrupoDeHabilidad(Long idGrupoHabilidadBorrar);
}
