package com.maurote.portfolio.service;

import java.util.List;

import com.maurote.portfolio.entity.Proyecto;

public interface IProyectoService {
    public List<Proyecto> listarProyecto();
    public void agregarProyecto(Proyecto pro);
    public void borrarProyecto(Long id);
}
