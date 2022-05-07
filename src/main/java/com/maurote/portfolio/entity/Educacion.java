package com.maurote.portfolio.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String lugar;
    private String url;
    private String periodo;
    private String texto; 

    private String imagenId;
    private String imagenUrl;
    
    public Educacion() {
    }

    public Educacion(String titulo, String lugar, String url, String periodo, String texto, String imagenUrl, String imagenId) {
        this.titulo = titulo;
        this.lugar = lugar;
        this.url = url;
        this.periodo = periodo;
        this.texto = texto;
        this.imagenUrl = imagenUrl;
        this.imagenId = imagenId;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getImagenUrl() {
        return this.imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getImagenId() {
        return this.imagenId;
    }

    public void setImagenId(String imagenId) {
        this.imagenId = imagenId;
    }

}
