package com.maurote.portfolio.service;

import com.maurote.portfolio.entity.Habilidad;
import com.maurote.portfolio.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadService implements IHabilidadService {
    
    @Autowired
    public HabilidadRepository habRepo;

    @Override
    public List<Habilidad> listarHabilidad() {
        return habRepo.findAll();
    }

    @Override
    public void agregarHabilidad(Habilidad hab) {
        habRepo.save(hab);
    }

    @Override
    public void borrarHabilidad(Long id) {
        habRepo.deleteById(id);
    }
    
}
