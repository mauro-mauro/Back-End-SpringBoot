package com.maurote.portfolio.controller;

import java.util.List;

import com.maurote.portfolio.entity.Experiencia;
import com.maurote.portfolio.entity.Mensaje;
import com.maurote.portfolio.models.ExperienciaDto;
import com.maurote.portfolio.service.IExperienciaService;

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
@RequestMapping("/experiencia")
public class ExperienciaController {
    @Autowired
    private IExperienciaService expServ;

    @PostMapping("/nuevo")
    public void agregarExperiencia(@RequestBody Experiencia exp) {
        expServ.agregarExperiencia(exp);
    }

    @GetMapping("/listar")
    public List<Experiencia> listarExperiencia() {
        return expServ.listarExperiencia();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Experiencia> obtenerPorId(@PathVariable("id") Long id) {
        if (!expServ.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = expServ.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody ExperienciaDto experienciaDto) {
        if (!expServ.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        /*
         * if(productoService.existsByNombre(productoDto.getNombre()) &&
         * productoService.getByNombre(productoDto.getNombre()).get().getId() != id)
         * return new ResponseEntity(new Mensaje("ese nombre ya existe"),
         * HttpStatus.BAD_REQUEST);
         * if(StringUtils.isBlank(productoDto.getNombre()))
         * return new ResponseEntity(new Mensaje("el nombre es obligatorio"),
         * HttpStatus.BAD_REQUEST);
         * if(productoDto.getPrecio()==null || productoDto.getPrecio()<0 )
         * return new ResponseEntity(new Mensaje("el precio debe ser mayor que 0"),
         * HttpStatus.BAD_REQUEST);
         */
        Experiencia experiencia = expServ.getOne(id).get();
        // if(experienciaDto.getLugar()!=null)
        experiencia.setLugar(experienciaDto.getLugar());
        // if(experienciaDto.getPeriodo()!=null)
        experiencia.setPeriodo(experienciaDto.getPeriodo());
        // if(experienciaDto.getTexto()!=null)
        experiencia.setTexto(experienciaDto.getTexto());
        // if(experienciaDto.getTitulo()!=null)
        experiencia.setTitulo(experienciaDto.getTitulo());
        // if(experienciaDto.getUrl()!=null)
        experiencia.setUrl(experienciaDto.getUrl());

        expServ.agregarExperiencia(experiencia);

        return new ResponseEntity(new Mensaje("experiencia actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarExperiencia(@PathVariable Long id) {
        expServ.borrarExperiencia(id);
    }
}
