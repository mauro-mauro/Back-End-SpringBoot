package com.maurote.portfolio.service;

import com.maurote.portfolio.model.Experiencia;
import java.util.List;
import java.util.Optional;

public interface IExperienciaService {
    public List<Experiencia> listarExperiencia();
    public void agregarExperiencia(Experiencia exp);
    public boolean existePorId(Long id);
    public void borrarExperiencia(Long id);
    public Optional<Experiencia> getOne(Long id);
}
