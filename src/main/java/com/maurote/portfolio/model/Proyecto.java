package com.maurote.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
    
    
}
