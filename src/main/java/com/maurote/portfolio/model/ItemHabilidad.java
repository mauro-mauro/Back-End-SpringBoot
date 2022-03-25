package com.maurote.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemHabilidad {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String habilidad;
    private int porcentaje;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "habilidad_id") 
    @JsonIgnore
    private Habilidad hab;

    public ItemHabilidad() {
    }

    public ItemHabilidad(long id, String habilidad, int porcentaje) {
        this.id = id;
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHabilidad() {
        return this.habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public int getPorcentaje() {
        return this.porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Habilidad getHab() {
        return this.hab;
    }

    public void setHab(Habilidad hab) {
        this.hab = hab;
    }

    
    
    
}
