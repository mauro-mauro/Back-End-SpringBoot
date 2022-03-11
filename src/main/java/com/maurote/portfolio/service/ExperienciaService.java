package com.maurote.portfolio.service;

import com.maurote.portfolio.model.Experiencia;
import com.maurote.portfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
    
    @Autowired
    public ExperienciaRepository expRepo;

    @Override
    public List<Experiencia> listarExperiencia() {
        return expRepo.findAll();
    }

    
    @Override
    public void agregarExperiencia(Experiencia exp) {
        expRepo.save(exp);
    }

    @Override
    public void borrarExperiencia(Long id) {
        expRepo.deleteById(id);
    }
}
