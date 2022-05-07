package com.maurote.portfolio.models;

import javax.validation.constraints.NotBlank;

public class EducacionDto {
    @NotBlank
    private String titulo;
    @NotBlank
    private String lugar;
    @NotBlank
    private String periodo;
    private String texto; 

    private String imagenId;
    private String imagenUrl; 

    public EducacionDto() {
    }

    public EducacionDto(String titulo, String lugar, String periodo, String texto, String imagenId, String imagenUrl) {
        this.titulo = titulo;
        this.lugar = lugar;
        this.periodo = periodo;
        this.texto = texto;
        this.imagenId = imagenId;
        this.imagenUrl = imagenUrl;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLugar() {
        return this.lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getImagenId() {
        return this.imagenId;
    }

    public void setImagenId(String imagenId) {
        this.imagenId = imagenId;
    }

    public String getImagenUrl() {
        return this.imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
}
