package com.maurote.portfolio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GrupoHabilidad {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String grupoHabilidad;

    public GrupoHabilidad() {
    }    
    
    public GrupoHabilidad(long id, String grupoHabilidad) {
        this.id = id;
        this.grupoHabilidad = grupoHabilidad;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGrupoHabilidad() {
        return this.grupoHabilidad;
    }

    public void setGrupoHabilidad(String grupoHabilidad) {
        this.grupoHabilidad = grupoHabilidad;
    }    
    
}
