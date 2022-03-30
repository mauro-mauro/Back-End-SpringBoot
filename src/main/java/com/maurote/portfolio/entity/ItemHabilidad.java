package com.maurote.portfolio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class ItemHabilidad {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String habilidad;
    private int porcentaje;
    
    @ManyToOne
    //(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "habilidad_id") 
    @JsonIgnore
    private Habilidad hab;

    public ItemHabilidad() {
    }

    public ItemHabilidad(long id, String habilidad, int porcentaje, Habilidad hab) {
        this.id = id;
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
        this.hab = hab;
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
