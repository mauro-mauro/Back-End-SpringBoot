package com.maurote.portfolio.service;

import com.maurote.portfolio.model.ItemHabilidad;
import java.util.List;

public interface IItemHabilidadService {
    public List<ItemHabilidad> listarItemHabilidad();
    public void agregarItemHabilidad(ItemHabilidad itemHab);
    public void borrarItemHabilidad(Long id);
}
