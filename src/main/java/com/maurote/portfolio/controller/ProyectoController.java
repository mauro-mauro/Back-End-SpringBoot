package com.maurote.portfolio.controller;

import java.util.List;

import com.maurote.portfolio.entity.Proyecto;
import com.maurote.portfolio.service.IProyectoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"${crossorigin.origin}"})
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    private IProyectoService proServ;
    
    @PostMapping("/nuevo")
    public void agregarProyecto(@RequestBody Proyecto pro) {
        proServ.agregarProyecto(pro);
    }

    @GetMapping("/listar")
    public List<Proyecto> listarProyecto() {
        return proServ.listarProyecto();
    }
    
}
