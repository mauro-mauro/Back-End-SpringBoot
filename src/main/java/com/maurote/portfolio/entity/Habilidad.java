package com.maurote.portfolio.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Habilidad {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String plataforma;
    
    @OneToMany(mappedBy = "hab", cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    public Set<ItemHabilidad> listaHabilidad;

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

    public Set<ItemHabilidad> getListaHabilidad() {
        return this.listaHabilidad;
    }

    public void setListaHabilidad(Set<ItemHabilidad> listaHabilidad) {
        this.listaHabilidad = listaHabilidad;
    }
    
    
}
