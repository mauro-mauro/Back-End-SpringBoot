package com.maurote.portfolio.models;

import com.maurote.portfolio.entity.Plataforma;

public class HabilidadDto {

    private int porcentaje;
    private String habilidad;
    private Plataforma plataforma;

    public HabilidadDto() {
    }

    public HabilidadDto(int porcentaje, String habilidad, Plataforma plataforma) {
        this.porcentaje = porcentaje;
        this.habilidad = habilidad;
        this.plataforma = plataforma;
    }

    public int getPorcentaje() {
        return this.porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getHabilidad() {
        return this.habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public Plataforma getPlataforma() {
        return this.plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }
    

}
