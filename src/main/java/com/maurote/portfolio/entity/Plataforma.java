package com.maurote.portfolio.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Plataforma {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String plataforma;
    
    @OneToMany(mappedBy = "plataforma", cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    public Set<Habilidad> listaHabilidad;

    public Plataforma() {
    }    
    
    public Plataforma(long id, String plataforma) {
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

    public Set<Habilidad> getListaHabilidad() {
        return this.listaHabilidad;
    }

    public void setListaHabilidad(Set<Habilidad> listaHabilidad) {
        this.listaHabilidad = listaHabilidad;
    }
    
    
}
