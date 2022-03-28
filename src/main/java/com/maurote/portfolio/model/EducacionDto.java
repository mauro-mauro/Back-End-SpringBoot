package com.maurote.portfolio.model;

import javax.validation.constraints.NotBlank;

public class EducacionDto {
    @NotBlank
    private String titulo;
    @NotBlank
    private String lugar;
    private String url;
    @NotBlank
    private String periodo;
    private String texto; 

    public EducacionDto() {
    }
    
    public EducacionDto(@NotBlank String titulo, @NotBlank String lugar, 
            String url, @NotBlank String periodo, String texto) {
        this.titulo = titulo;
        this.lugar = lugar;
        this.url = url;
        this.periodo = periodo;
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
