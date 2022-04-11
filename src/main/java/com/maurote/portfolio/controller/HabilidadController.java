package com.maurote.portfolio.controller;
import java.util.List;

import com.maurote.portfolio.entity.Habilidad;
import com.maurote.portfolio.entity.Mensaje;
import com.maurote.portfolio.service.IHabilidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"${crossorigin.origin}"})
public class HabilidadController {
    @Autowired
    private IHabilidadService habServ;

    @PostMapping("/habilidad/nuevo")
    public void agregarProyecto(@RequestBody Habilidad hab) {
        habServ.agregarHabilidad(hab);
    }

    @GetMapping("/habilidad/listar")
    public List<Habilidad> listarHabilidad() {
        return habServ.listarHabilidad();
    }

    @GetMapping("/habilidad/buscar/{id}")
    public ResponseEntity<Habilidad> obtenerHabilidadPorId(@PathVariable("id") Long id) {
        if (!habServ.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Habilidad habilidad = habServ.getOne(id).get();
        return new ResponseEntity(habilidad, HttpStatus.OK);
    }

    @GetMapping("/habilidad-plataformas/listar")
    public List<Habilidad> listarHabilidadSimple() {
        List<Habilidad> plataformas = habServ.listarHabilidad();
        for(Habilidad temp : plataformas){
            temp.setListaHabilidad(null);
        }

        return plataformas;
    }
}
