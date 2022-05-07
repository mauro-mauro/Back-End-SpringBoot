package com.maurote.portfolio.controller;
import java.util.List;

import com.maurote.portfolio.entity.Habilidad;
import com.maurote.portfolio.entity.Mensaje;
import com.maurote.portfolio.models.HabilidadDto;
import com.maurote.portfolio.service.IHabilidadService;

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
@RequestMapping("/habilidad")
public class HabilidadController {
    @Autowired
    private IHabilidadService habilidadSer;

    // ---------------------Item Habilidad-------------------------------
    @GetMapping("/listar")
    public List<Habilidad> listarItemHabilidad() {
        return habilidadSer.listarHabilidad();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> agregarHabilidad(@RequestBody HabilidadDto habilidadDto) {
        Habilidad habilidad = new Habilidad();
        habilidad.setHabilidad(habilidadDto.getHabilidad());
        habilidad.setPorcentaje(habilidadDto.getPorcentaje());

        habilidadSer.agregarHabilidad(habilidad);
        return new ResponseEntity(new Mensaje("agregado correctamente"), HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> updateItemHabilidad(@PathVariable("id") long id, @RequestBody HabilidadDto habilidadDto) {
        if (!habilidadSer.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Habilidad habilidad = habilidadSer.getOne(id).get();
        habilidad.setHabilidad(habilidadDto.getHabilidad());
        habilidad.setPorcentaje(habilidadDto.getPorcentaje());

        habilidadSer.agregarHabilidad(habilidad);

        return new ResponseEntity(new Mensaje("experiencia actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarItemHabilidad(@PathVariable Long id) {
        habilidadSer.borrarHabilidad(id);
    }
}
