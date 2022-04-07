package com.maurote.portfolio.service;

import java.util.List;
import java.util.Optional;

import com.maurote.portfolio.entity.ItemHabilidad;

public interface IItemHabilidadService {
    public List<ItemHabilidad> listarItemHabilidad();
    public void agregarItemHabilidad(ItemHabilidad itemHab);
    public void borrarItemHabilidad(Long id);
    public boolean existePorId(Long id);
    public Optional<ItemHabilidad> getOne(Long id);
}
