package com.maurote.portfolio.service;

import java.util.List;
import java.util.Optional;

import com.maurote.portfolio.entity.Proyecto;

public interface IProyectoService {
    public List<Proyecto> listarProyecto();
    public void agregarProyecto(Proyecto pro);
    public void borrarProyecto(Long id);
    public boolean existePorId(Long id);
    public Optional<Proyecto> getOne(Long id);
}
