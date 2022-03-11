package com.maurote.portfolio.service;

import com.maurote.portfolio.model.DatoPersonal;
import java.util.List;

public interface IDatoPersonalService {
    public List<DatoPersonal> listarDatoPersonal();
    public void agregarDatoPersonal(DatoPersonal exp);
    public void borrarDatoPersonal(Long id);

}
