package com.maurote.portfolio.service;

import java.util.List;
import java.util.Optional;

import com.maurote.portfolio.entity.Experiencia;

public interface IExperienciaService {
    public List<Experiencia> listarExperiencia();
    public void agregarExperiencia(Experiencia exp);
    public void borrarExperiencia(Long id);
    public boolean existePorId(Long id);
    public Optional<Experiencia> getOne(Long id);
    public void borrarPorObjeto(Experiencia exp);
}
