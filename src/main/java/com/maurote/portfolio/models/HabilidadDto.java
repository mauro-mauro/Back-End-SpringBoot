package com.maurote.portfolio.models;

import com.maurote.portfolio.entity.GrupoHabilidad;

public class HabilidadDto {

    private int porcentaje;
    private String habilidad;
    private String grupoHabilidad;

    public HabilidadDto() {
    }

    public HabilidadDto(int porcentaje, String habilidad, String grupoHabilidad) {
        this.porcentaje = porcentaje;
        this.habilidad = habilidad;
        this.grupoHabilidad = grupoHabilidad;
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

    public String getGrupoHabilidad() {
        return this.grupoHabilidad;
    }

    public void setGrupoHabilidad(String grupoHabilidad) {
        this.grupoHabilidad = grupoHabilidad;
    }
    

}
