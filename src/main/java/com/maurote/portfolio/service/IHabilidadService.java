package com.maurote.portfolio.service;

import com.maurote.portfolio.model.Habilidad;
import java.util.List;

public interface IHabilidadService {
    public List<Habilidad> listarHabilidad();
    public void agregarHabilidad(Habilidad hab);
    public void borrarHabilidad(Long id);
}
