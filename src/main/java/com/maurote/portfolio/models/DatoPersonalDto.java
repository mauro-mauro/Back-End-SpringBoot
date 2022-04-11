package com.maurote.portfolio.models;

public class DatoPersonalDto {
    private String nombre;
    private String profesion;
    private String texto;
    private String urlFacebook;
    private String urlGitHub;
    private String urlImagenPortada;
    private String urlImagenPerfil;
    

    public DatoPersonalDto() {
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
    
}
