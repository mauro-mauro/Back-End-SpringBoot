package com.maurote.portfolio.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class Habilidad {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String habilidad;
    private int porcentaje;
    
    @JsonIgnore
    private long id_grupoHabilidad;

    public Habilidad() {
    }

    public Habilidad(long id, String habilidad, int porcentaje) {
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

    public long getId_grupoHabilidad() {
        return this.id_grupoHabilidad;
    }

    public void setId_grupoHabilidad(long id_grupoHabilidad) {
        this.id_grupoHabilidad = id_grupoHabilidad;
    }
    
    
}
