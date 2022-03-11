package com.maurote.portfolio.service;

import com.maurote.portfolio.model.Experiencia;
import java.util.List;

public interface IExperienciaService {
    public List<Experiencia> listarExperiencia();
    public void agregarExperiencia(Experiencia exp);
    public void borrarExperiencia(Long id);
}
