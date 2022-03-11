package com.maurote.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String lugar;
    private String url;
    private String periodo;
    private String texto; 
    
    public Experiencia() {
    }
    
    public Experiencia(long id, String titulo, String lugar, String url, String periodo, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.lugar = lugar;
        this.url = url;
        this.periodo = periodo;
        this.texto = texto;
    }
    
    
}
