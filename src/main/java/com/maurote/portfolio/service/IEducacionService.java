package com.maurote.portfolio.service;

import com.maurote.portfolio.model.Educacion;
import java.util.List;

public interface IEducacionService {
    public List<Educacion> listarEducacion();
    public void agregarEducacion(Educacion edu);
    public void borrarEducacion(Long id);
}
