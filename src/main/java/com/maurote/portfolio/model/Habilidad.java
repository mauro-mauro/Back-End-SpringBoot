package com.maurote.portfolio.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Habilidad {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String plataforma;
    
    @OneToMany(mappedBy = "hab", cascade = {CascadeType.ALL})
    public List<ItemHabilidad> listaHabilidad;

    public Habilidad() {
    }    
    
    public Habilidad(long id, String plataforma) {
        this.id = id;
        this.plataforma = plataforma;
    }
    
    
}
