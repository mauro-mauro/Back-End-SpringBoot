package com.maurote.portfolio.service;

import com.maurote.portfolio.model.DatoPersonal;
import com.maurote.portfolio.repository.DatoPersonalRepository;
import java.util.List;
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
    
}
