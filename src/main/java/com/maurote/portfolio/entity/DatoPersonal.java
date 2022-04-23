package com.maurote.portfolio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DatoPersonal {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String profesion;
    private String texto;
    private String urlFacebook;
    private String urlGitHub;
    private String urlImagenPortada;
    private String urlImagenPerfil;

    @OneToOne
    private Imagen imagenPortada;

    @OneToOne
    private Imagen imagenPerfil;

    public DatoPersonal() {
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
    

    public String getUrlFacebook() {
        return this.urlFacebook;
    }

    public void setUrlFacebook(String urlFacebook) {
        this.urlFacebook = urlFacebook;
    }

    public String getUrlGitHub() {
        return this.urlGitHub;
    }

    public void setUrlGitHub(String urlGitHub) {
        this.urlGitHub = urlGitHub;
    }

    public Imagen getImagenPortada() {
        return this.imagenPortada;
    }

    public void setImagenPortada(Imagen imagenPortada) {
        this.imagenPortada = imagenPortada;
    }

    public Imagen getImagenPerfil() {
        return this.imagenPerfil;
    }

    public void setImagenPerfil(Imagen imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }
    
}
