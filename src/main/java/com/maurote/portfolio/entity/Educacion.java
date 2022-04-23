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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="imagen_id")
    private Imagen imagen;
    
    public Educacion() {
    }
    
    public Educacion(long id, String titulo, String lugar, String url, String periodo, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.lugar = lugar;
        this.url = url;
        this.periodo = periodo;
        this.texto = texto;
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

    public Imagen getImagen() {
        return this.imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

}
