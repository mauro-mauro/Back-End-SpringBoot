package com.maurote.portfolio.service;

import com.maurote.portfolio.entity.GrupoHabilidad;
import com.maurote.portfolio.repository.GrupoHabilidadRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoHabilidadService implements IGrupoHabilidadService {
    
    @Autowired
    public GrupoHabilidadRepository grupoHabilidadRepo;

    @Override
    public List<GrupoHabilidad> listarGrupoHabilidad() {
        return grupoHabilidadRepo.findAll();
    }

    @Override
    public void agregarGrupoHabilidad(GrupoHabilidad grupoHabilidad) {
        grupoHabilidadRepo.save(grupoHabilidad);
    }

    @Override
    public void borrarGrupoHabilidadPorId(Long id) {
        grupoHabilidadRepo.deleteById(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return grupoHabilidadRepo.existsById(id);
    }

    @Override
    public Optional<GrupoHabilidad> getOne(Long id) {
        return grupoHabilidadRepo.findById(id);
    }

    @Override
    public Optional<GrupoHabilidad> findByGrupoHabilidadContaining(String nombre) {
        return grupoHabilidadRepo.findByGrupoHabilidadContaining(nombre);
    }

    @Override
    public void borrarGrupoHabilidadPorObjeto(GrupoHabilidad grupoHab) {
        grupoHabilidadRepo.delete(grupoHab);        
    }

    
    
}
