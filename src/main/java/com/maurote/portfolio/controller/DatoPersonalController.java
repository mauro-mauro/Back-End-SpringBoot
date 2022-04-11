package com.maurote.portfolio.controller;

import java.util.List;

import com.maurote.portfolio.entity.DatoPersonal;
import com.maurote.portfolio.entity.Mensaje;
import com.maurote.portfolio.models.DatoPersonalDto;
import com.maurote.portfolio.service.IDatoPersonalService;

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
@CrossOrigin(origins = { "${crossorigin.origin}" })
@RequestMapping("/dato-personal")
public class DatoPersonalController {

    @Autowired
    private IDatoPersonalService datoPerSer;

    @PostMapping("/nuevo")
    public void agregarDatoPersonal(@RequestBody DatoPersonal datoPer) {
        datoPerSer.agregarDatoPersonal(datoPer);
    }

    @GetMapping("/listar")
    public List<DatoPersonal> listarDatoPersonal() {
        return datoPerSer.listarDatoPersonal();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<DatoPersonal> obtenerDatoPersonalPorId(@PathVariable("id") Long id) {
        if (!datoPerSer.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        DatoPersonal datoPersonal = datoPerSer.getOne(id).get();
        return new ResponseEntity(datoPersonal, HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> updateEducacion(@PathVariable("id") long id,
            @RequestBody DatoPersonalDto datoPersonalDto) {
        if (!datoPerSer.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        DatoPersonal datoPersonal = datoPerSer.getOne(id).get();
        datoPersonal.setNombre(datoPersonalDto.getNombre());
        datoPersonal.setProfesion(datoPersonalDto.getProfesion());
        datoPersonal.setTexto(datoPersonalDto.getTexto());
        datoPersonal.setUrlFacebook(datoPersonalDto.getUrlFacebook());
        datoPersonal.setUrlGitHub(datoPersonalDto.getUrlGitHub());
        datoPersonal.setUrlImagenPortada(datoPersonalDto.getUrlImagenPortada());
        datoPersonal.setUrlImagenPerfil(datoPersonalDto.getUrlImagenPerfil());

        datoPerSer.agregarDatoPersonal(datoPersonal);

        return new ResponseEntity(new Mensaje("dato personal actualizado"), HttpStatus.OK);
    }

}
