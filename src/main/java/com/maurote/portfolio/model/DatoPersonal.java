package com.maurote.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
    
    
}
