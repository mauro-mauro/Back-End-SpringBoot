package com.maurote.portfolio.service;

import java.util.List;

import com.maurote.portfolio.entity.DatoPersonal;

public interface IDatoPersonalService {
    public List<DatoPersonal> listarDatoPersonal();
    public void agregarDatoPersonal(DatoPersonal exp);
    public void borrarDatoPersonal(Long id);

}
