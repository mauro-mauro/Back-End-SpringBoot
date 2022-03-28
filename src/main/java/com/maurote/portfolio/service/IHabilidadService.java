package com.maurote.portfolio.service;

import java.util.List;

import com.maurote.portfolio.entity.Habilidad;

public interface IHabilidadService {
    public List<Habilidad> listarHabilidad();
    public void agregarHabilidad(Habilidad hab);
    public void borrarHabilidad(Long id);
}
