package com.maurote.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class ItemHabilidad {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String habilidad;
    private int porcentaje;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "habilidad_id") 
    @JsonIgnore
    private Habilidad hab;

    public ItemHabilidad() {
    }

    public ItemHabilidad(long id, String habilidad, int porcentaje) {
        this.id = id;
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }

    
    
    
}
