package com.maurote.portfolio.service;

import com.maurote.portfolio.entity.ItemHabilidad;
import com.maurote.portfolio.repository.ItemHabilidadRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemHabilidadService implements IItemHabilidadService {

    @Autowired
    private ItemHabilidadRepository itemHabRepo;

    @Override
    public List<ItemHabilidad> listarItemHabilidad() {
        return itemHabRepo.findAll();
    }

    @Override
    public void agregarItemHabilidad(ItemHabilidad itemHab) {
        itemHabRepo.save(itemHab);
    }

    @Override
    public void borrarItemHabilidad(Long id) {
        itemHabRepo.deleteById(id);
    }

}
