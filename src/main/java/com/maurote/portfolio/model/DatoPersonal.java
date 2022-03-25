package com.maurote.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DatoPersonal {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String urlImagenPortada;
    private String urlImagenPerfil;
    private String nombre;
    private String profesion;
    private String texto;

    public DatoPersonal() {
    }

    public DatoPersonal(long id, String urlImagenPortada, String urlImagenPerfil, String nombre, String profesion, String texto) {
        this.id = id;
        this.urlImagenPortada = urlImagenPortada;
        this.urlImagenPerfil = urlImagenPerfil;
        this.nombre = nombre;
        this.profesion = profesion;
        this.texto = texto;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrlImagenPortada() {
        return this.urlImagenPortada;
    }

    public void setUrlImagenPortada(String urlImagenPortada) {
        this.urlImagenPortada = urlImagenPortada;
    }

    public String getUrlImagenPerfil() {
        return this.urlImagenPerfil;
    }

    public void setUrlImagenPerfil(String urlImagenPerfil) {
        this.urlImagenPerfil = urlImagenPerfil;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return this.profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
}
