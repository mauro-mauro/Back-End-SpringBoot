package com.maurote.portfolio.service;

import com.maurote.portfolio.model.Educacion;
import java.util.List;
import java.util.Optional;

public interface IEducacionService {
    public List<Educacion> listarEducacion();
    public void agregarEducacion(Educacion edu);
    public void borrarEducacion(Long id);
    public boolean existePorId(Long id);
    public Optional<Educacion> getOne(Long id);
}
