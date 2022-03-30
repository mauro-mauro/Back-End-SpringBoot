package com.maurote.portfolio.models;

import java.util.Set;

public class HabilidadDto {
    private String plataforma;
    public Set<ItemHabilidadDto> listaHabilidad;

    public HabilidadDto() {
    }

    public HabilidadDto(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return this.plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Set<ItemHabilidadDto> getListaHabilidad() {
        return this.listaHabilidad;
    }

    public void setListaHabilidad(Set<ItemHabilidadDto> listaHabilidad) {
        this.listaHabilidad = listaHabilidad;
    }

}
