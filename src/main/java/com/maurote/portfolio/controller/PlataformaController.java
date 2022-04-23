package com.maurote.portfolio.controller;
import java.util.List;

import com.maurote.portfolio.entity.Plataforma;
import com.maurote.portfolio.models.PlataformaDto;
import com.maurote.portfolio.entity.Mensaje;
import com.maurote.portfolio.service.IPlataformaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"${crossorigin.origin}"})
public class PlataformaController {
    @Autowired
    private IPlataformaService plataformaServ;

    @PostMapping("/plataforma/nuevo")
    public ResponseEntity<?> agregarPlataforma(@RequestBody Plataforma plataforma) {
        plataformaServ.agregarPlataforma(plataforma);
        return new ResponseEntity(new Mensaje("Agregado correctamente"), HttpStatus.OK);
    }

    @GetMapping("/plataforma/listar")
    public List<Plataforma> listarPlataforma() {
        return plataformaServ.listarPlataforma();
    }

    @GetMapping("/plataforma/buscar/{id}")
    public ResponseEntity<Plataforma> obtenerPlataformaPorId(@PathVariable("id") Long id) {
        if (!plataformaServ.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Plataforma plataforma = plataformaServ.getOne(id).get();
        return new ResponseEntity(plataforma, HttpStatus.OK);
    }

    @PutMapping("/plataforma/editar/{id}")
    public ResponseEntity<?> editarPlataforma(@PathVariable("id") long id, @RequestBody PlataformaDto plataformaDto){
        if (!plataformaServ.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Plataforma plataforma = plataformaServ.getOne(id).get();
        plataforma.setPlataforma(plataformaDto.getPlataforma());

        plataformaServ.agregarPlataforma(plataforma);

        return new ResponseEntity(new Mensaje("Actualizado correctamente"), HttpStatus.OK);
    }

    @GetMapping("/habilidad-plataformas/listar")
    public List<Plataforma> listarPlataformaSimple() {
        List<Plataforma> plataformas = plataformaServ.listarPlataforma();
        for(Plataforma temp : plataformas){
            temp.setListaHabilidad(null);
        }

        return plataformas;
    }
}
