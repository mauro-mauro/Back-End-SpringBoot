package com.maurote.portfolio.service;

import com.maurote.portfolio.entity.Plataforma;
import com.maurote.portfolio.repository.PlataformaRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlataformaService implements IPlataformaService {
    
    @Autowired
    public PlataformaRepository plataformaRepo;

    @Override
    public List<Plataforma> listarPlataforma() {
        return plataformaRepo.findAll();
    }

    @Override
    public void agregarPlataforma(Plataforma plataforma) {
        plataformaRepo.save(plataforma);
    }

    @Override
    public void borrarPlataforma(Long id) {
        plataformaRepo.deleteById(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return plataformaRepo.existsById(id);
    }

    @Override
    public Optional<Plataforma> getOne(Long id) {
        return plataformaRepo.findById(id);
    }
    
}
