package com.maurote.portfolio.service;

import com.maurote.portfolio.entity.Proyecto;
import com.maurote.portfolio.repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService {

    @Autowired
    public ProyectoRepository proRepo;
    
    @Override
    public List<Proyecto> listarProyecto() {
        return proRepo.findAll();
    }

    @Override
    public void agregarProyecto(Proyecto pro) {
        proRepo.save(pro);
    }

    @Override
    public void borrarProyecto(Long id) {
        proRepo.deleteById(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return proRepo.existsById(id);
    }

    @Override
    public Optional<Proyecto> getOne(Long id) {
        return proRepo.findById(id);
    }
    
}
