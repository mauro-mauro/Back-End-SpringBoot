package com.maurote.portfolio.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String nombreProyecto;
    private String programa;
    private String repositorioGit;
    private String anio;
    private String texto;

    private String imagenUrl;
    private String imagenId;

    public Proyecto() {
    }

    public Proyecto(String nombreProyecto, String programa, String repositorioGit, String anio, String texto, String imagenUrl, String imagenId) {
        this.nombreProyecto = nombreProyecto;
        this.programa = programa;
        this.repositorioGit = repositorioGit;
        this.anio = anio;
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

    public String getNombreProyecto() {
        return this.nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getPrograma() {
        return this.programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
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
