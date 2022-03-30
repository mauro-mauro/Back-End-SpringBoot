package com.maurote.portfolio.models;

import com.maurote.portfolio.entity.Habilidad;

public class ItemHabilidadDto {

    private int porcentaje;
    private String habilidad;
    private Habilidad hab;

    public ItemHabilidadDto() {
    }

    public ItemHabilidadDto(int porcentaje, String habilidad, Habilidad hab) {
        this.porcentaje = porcentaje;
        this.habilidad = habilidad;
        this.hab = hab;
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

    public Habilidad getHab() {
        return this.hab;
    }

    public void setHab(Habilidad hab) {
        this.hab = hab;
    }
    

}
