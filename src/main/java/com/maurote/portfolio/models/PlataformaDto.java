package com.maurote.portfolio.models;

import java.util.Set;

public class PlataformaDto {
    private String plataforma;
    public Set<HabilidadDto> listaHabilidad;

    public PlataformaDto() {
    }

    public PlataformaDto(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getPlataforma() {
        return this.plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Set<HabilidadDto> getListaHabilidad() {
        return this.listaHabilidad;
    }

    public void setListaHabilidad(Set<HabilidadDto> listaHabilidad) {
        this.listaHabilidad = listaHabilidad;
    }

}
