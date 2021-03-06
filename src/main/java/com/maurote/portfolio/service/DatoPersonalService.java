package com.maurote.portfolio.service;

import com.maurote.portfolio.entity.DatoPersonal;
import com.maurote.portfolio.repository.DatoPersonalRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatoPersonalService implements IDatoPersonalService {

    @Autowired
    public DatoPersonalRepository datoPerRepo;
    
    @Override
    public List<DatoPersonal> listarDatoPersonal() {
        return datoPerRepo.findAll();
    }

    @Override
    public void agregarDatoPersonal(DatoPersonal exp) {
        datoPerRepo.save(exp);
    }

    @Override
    public void borrarDatoPersonal(Long id) {
        datoPerRepo.deleteById(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return datoPerRepo.existsById(id);
    }

    @Override
    public Optional<DatoPersonal> getOne(Long id) {
        return datoPerRepo.findById(id);
    }
    
}
