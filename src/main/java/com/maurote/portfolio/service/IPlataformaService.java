package com.maurote.portfolio.service;

import java.util.List;
import java.util.Optional;

import com.maurote.portfolio.entity.Plataforma;

public interface IPlataformaService {
    public List<Plataforma> listarPlataforma();
    public void agregarPlataforma(Plataforma plat);
    public void borrarPlataforma(Long id);
    public boolean existePorId(Long id);
    public Optional<Plataforma> getOne(Long id);
}
