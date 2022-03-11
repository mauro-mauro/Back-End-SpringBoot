package com.maurote.portfolio.service;

import com.maurote.portfolio.model.Proyecto;
import java.util.List;

public interface IProyectoService {
    public List<Proyecto> listarProyecto();
    public void agregarProyecto(Proyecto pro);
    public void borrarProyecto(Long id);
}
