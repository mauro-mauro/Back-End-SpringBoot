package com.maurote.portfolio.controller;
import java.util.List;

import com.maurote.portfolio.entity.GrupoHabilidad;
import com.maurote.portfolio.entity.Mensaje;
import com.maurote.portfolio.models.GrupoHabilidadDto;
import com.maurote.portfolio.service.IGrupoHabilidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"${crossorigin.origin}"})
@RequestMapping("/grupo-habilidad")
public class GrupoHabilidadController {
    @Autowired
    private IGrupoHabilidadService grupoHabilidadServ;

    @PostMapping("/nuevo")
    public ResponseEntity<?> agregarGrupoHabilidad(@RequestBody GrupoHabilidad grupoHabilidad) {
        grupoHabilidadServ.agregarGrupoHabilidad(grupoHabilidad);
        return new ResponseEntity(new Mensaje("Agregado correctamente"), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<GrupoHabilidad>> listarGrupoHabilidad() {
        return new ResponseEntity<>(grupoHabilidadServ.listarGrupoHabilidad(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<GrupoHabilidad> obtenerGrupoHabilidadPorId(@PathVariable("id") Long id) {
        if (!grupoHabilidadServ.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        GrupoHabilidad grupoHabilidad = grupoHabilidadServ.getOne(id).get();
        return new ResponseEntity(grupoHabilidad, HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarPlataforma(@PathVariable("id") long id, @RequestBody GrupoHabilidadDto grupoHabilidadDto){
        if (!grupoHabilidadServ.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        GrupoHabilidad grupoHabilidad = grupoHabilidadServ.getOne(id).get();
        grupoHabilidad.setGrupoHabilidad(grupoHabilidadDto.getGrupoHabilidad());

        grupoHabilidadServ.agregarGrupoHabilidad(grupoHabilidad);

        return new ResponseEntity(new Mensaje("Actualizado correctamente"), HttpStatus.OK);
    }

}
