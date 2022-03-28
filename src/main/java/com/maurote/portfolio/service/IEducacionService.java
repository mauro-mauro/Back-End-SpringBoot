package com.maurote.portfolio.service;

import java.util.List;
import java.util.Optional;

import com.maurote.portfolio.entity.Educacion;

public interface IEducacionService {
    public List<Educacion> listarEducacion();
    public void agregarEducacion(Educacion edu);
    public void borrarEducacion(Long id);
    public boolean existePorId(Long id);
    public Optional<Educacion> getOne(Long id);
}
