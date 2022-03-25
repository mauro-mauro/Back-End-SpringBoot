package com.maurote.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String programa;
    private String url;
    private String repositorioGit;
    private String anio;
    private String texto;

    public Proyecto() {
    }

    public Proyecto(long id, String titulo, String programa, String url, String repositorioGit, String anio, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.programa = programa;
        this.url = url;
        this.repositorioGit = repositorioGit;
        this.anio = anio;
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

    public String getPrograma() {
        return this.programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRepositorioGit() {
        return this.repositorioGit;
    }

    public void setRepositorioGit(String repositorioGit) {
        this.repositorioGit = repositorioGit;
    }

    public String getAnio() {
        return this.anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
}
