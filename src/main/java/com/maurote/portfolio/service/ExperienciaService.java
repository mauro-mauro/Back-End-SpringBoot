package com.maurote.portfolio.service;

import com.maurote.portfolio.entity.Experiencia;
import com.maurote.portfolio.repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
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

    @Override
    public boolean existePorId(Long id) {
        return expRepo.existsById(id);
    }

    @Override
    public Optional<Experiencia> getOne(Long id) {
        return expRepo.findById(id);
    }


    @Override
    public void borrarPorObjeto(Experiencia exp) {
        expRepo.delete(exp);        
    }
}
