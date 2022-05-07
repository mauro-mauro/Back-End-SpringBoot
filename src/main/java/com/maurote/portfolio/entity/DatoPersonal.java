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

    private String imagenPerfilUrl;
    private String imagenPerfilId;

    private String imagenPortadaUrl;
    private String imagenPortadaId;

    public DatoPersonal() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getImagenPerfilUrl() {
        return this.imagenPerfilUrl;
    }

    public void setImagenPerfilUrl(String imagenPerfilUrl) {
        this.imagenPerfilUrl = imagenPerfilUrl;
    }

    public String getImagenPerfilId() {
        return this.imagenPerfilId;
    }

    public void setImagenPerfilId(String imagenPerfilId) {
        this.imagenPerfilId = imagenPerfilId;
    }

    public String getImagenPortadaUrl() {
        return this.imagenPortadaUrl;
    }

    public void setImagenPortadaUrl(String imagenPortadaUrl) {
        this.imagenPortadaUrl = imagenPortadaUrl;
    }

    public String getImagenPortadaId() {
        return this.imagenPortadaId;
    }

    public void setImagenPortadaId(String imagenPortadaId) {
        this.imagenPortadaId = imagenPortadaId;
    }
    
}
