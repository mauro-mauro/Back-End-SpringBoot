package com.maurote.portfolio.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String lugar;
    private String periodo;
    private String texto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="imagen_id")
    private Imagen imagen;

    public Experiencia() {
    }

    public Experiencia(long id, String titulo, String lugar, String periodo, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.lugar = lugar;
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
