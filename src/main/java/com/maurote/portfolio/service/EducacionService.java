package com.maurote.portfolio.service;

import com.maurote.portfolio.entity.Educacion;
import com.maurote.portfolio.repository.EducacionRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService {

    @Autowired
    public EducacionRepository eduRepo;
    
    @Override
    public List<Educacion> listarEducacion() {
        return eduRepo.findAll();
    }

    @Override
    public void agregarEducacion(Educacion edu) {
        eduRepo.save(edu);
    }

    @Override
    public void borrarEducacion(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return eduRepo.existsById(id);
    }

    @Override
    public Optional<Educacion> getOne(Long id) {
        return eduRepo.findById(id);
    }
    
}
