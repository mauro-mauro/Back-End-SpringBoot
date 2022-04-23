package com.maurote.portfolio.models;

import javax.validation.constraints.NotBlank;

import com.maurote.portfolio.entity.Imagen;

public class ExperienciaDto {
    @NotBlank
    private String titulo;
    @NotBlank
    private String lugar;
    @NotBlank
    private String periodo;
    private String texto; 

    private Imagen imagen;

    public ExperienciaDto() {
    }
    
    public ExperienciaDto(@NotBlank String titulo, @NotBlank String lugar, 
            @NotBlank String periodo, String texto, Imagen imagen) {
        this.titulo = titulo;
        this.lugar = lugar;
        this.periodo = periodo;
        this.texto = texto;
        this.imagen = imagen;
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

    public Imagen getImagen() {
        return this.imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }
}
