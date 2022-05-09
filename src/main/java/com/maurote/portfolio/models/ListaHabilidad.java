package com.maurote.portfolio.models;

import java.util.List;

import com.maurote.portfolio.entity.Habilidad;

public class ListaHabilidad {
    private Long id;
    private String grupoHabilidad;
    private List<Habilidad> habilidades;


    public ListaHabilidad() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrupoHabilidad() {
        return this.grupoHabilidad;
    }

    public void setGrupoHabilidad(String grupoHabilidad) {
        this.grupoHabilidad = grupoHabilidad;
    }

    public List<Habilidad> getHabilidades() {
        return this.habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

}
