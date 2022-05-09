package com.maurote.portfolio.models;

public class DatoPersonalDto {
    private String nombre;
    private String profesion;
    private String texto;
    private String urlFacebook;
    private String urlGitHub;
    
    private String imagenPerfilId;
    private String imagenPerfilUrl;

    private String imagenPortadaId;
    private String imagenPortadaUrl;
    

    public DatoPersonalDto() {
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
