package com.maurote.portfolio.controller;

import java.util.List;

import com.maurote.portfolio.entity.Educacion;
import com.maurote.portfolio.entity.Mensaje;
import com.maurote.portfolio.models.EducacionDto;
import com.maurote.portfolio.service.IEducacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"${crossorigin.origin}"})
@RequestMapping("/educacion")
public class EducacionController {
    @Autowired
    private IEducacionService eduServ;
    
    @PostMapping("/nuevo")
    public void agregarEducacion(@RequestBody Educacion edu) {
        eduServ.agregarEducacion(edu);
    }

    @GetMapping("/listar")
    public List<Educacion> listarEducacion() {
        return eduServ.listarEducacion();
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarEducacion(@PathVariable Long id) {
        eduServ.borrarEducacion(id);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Educacion> obtenerEducacionPorId(@PathVariable("id") Long id) {
        if (!eduServ.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = eduServ.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> updateEducacion(@PathVariable("id") long id, @RequestBody EducacionDto educacionDto) {
        if (!eduServ.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = eduServ.getOne(id).get();
        educacion.setLugar(educacionDto.getLugar());
        educacion.setPeriodo(educacionDto.getPeriodo());
        educacion.setTexto(educacionDto.getTexto());
        educacion.setTitulo(educacionDto.getTitulo());
        educacion.setUrl(educacionDto.getUrl());

        eduServ.agregarEducacion(educacion);

        return new ResponseEntity(new Mensaje("experiencia actualizado"), HttpStatus.OK);
    }
}
