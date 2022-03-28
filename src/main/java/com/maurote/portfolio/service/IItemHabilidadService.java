package com.maurote.portfolio.service;

import java.util.List;

import com.maurote.portfolio.entity.ItemHabilidad;

public interface IItemHabilidadService {
    public List<ItemHabilidad> listarItemHabilidad();
    public void agregarItemHabilidad(ItemHabilidad itemHab);
    public void borrarItemHabilidad(Long id);
}
