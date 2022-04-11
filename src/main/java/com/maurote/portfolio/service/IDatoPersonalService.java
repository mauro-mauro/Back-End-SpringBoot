package com.maurote.portfolio.service;

import java.util.List;
import java.util.Optional;

import com.maurote.portfolio.entity.DatoPersonal;

public interface IDatoPersonalService {
    public List<DatoPersonal> listarDatoPersonal();
    public void agregarDatoPersonal(DatoPersonal exp);
    public void borrarDatoPersonal(Long id);
    public boolean existePorId(Long id);
    public Optional<DatoPersonal> getOne(Long id);

}
