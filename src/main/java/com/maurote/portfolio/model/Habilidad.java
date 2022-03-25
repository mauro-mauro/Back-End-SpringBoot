package com.maurote.portfolio.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Habilidad {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String plataforma;
    
    @OneToMany(mappedBy = "hab", cascade = {CascadeType.ALL})
    public List<ItemHabilidad> listaHabilidad;

    public Habilidad() {
    }    
    
    public Habilidad(long id, String plataforma) {
        this.id = id;
        this.plataforma = plataforma;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlataforma() {
        return this.plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public List<ItemHabilidad> getListaHabilidad() {
        return this.listaHabilidad;
    }

    public void setListaHabilidad(List<ItemHabilidad> listaHabilidad) {
        this.listaHabilidad = listaHabilidad;
    }
    
    
}
