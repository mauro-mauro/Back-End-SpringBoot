package com.maurote.portfolio.controller;
import java.util.List;

import com.maurote.portfolio.entity.ItemHabilidad;
import com.maurote.portfolio.entity.Mensaje;
import com.maurote.portfolio.models.ItemHabilidadDto;
import com.maurote.portfolio.service.IItemHabilidadService;

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
@RequestMapping("/item-habilidad")
public class ItemHabilidadController {
    @Autowired
    private IItemHabilidadService itemHabSer;

    // ---------------------Item Habilidad-------------------------------
    @GetMapping("/listar")
    public List<ItemHabilidad> listarItemHabilidad() {
        return itemHabSer.listarItemHabilidad();
    }

    @PostMapping("/nuevo")
    public void agregarItemHabilidad(@RequestBody ItemHabilidadDto itemHab) {
        System.out.println("itemHab.getHab(): " + itemHab.getHab());
        System.out.println("itemHab.getPorcentaje(): " + itemHab.getPorcentaje());
        System.out.println("itemHab.getHab(): " + itemHab.getHab());

        ItemHabilidad itemHabilidad = new ItemHabilidad();
        itemHabilidad.setHab(itemHab.getHab());
        itemHabilidad.setPorcentaje(itemHab.getPorcentaje());
        itemHabilidad.setHabilidad(itemHab.getHabilidad());

        itemHabSer.agregarItemHabilidad(itemHabilidad);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> updateItemHabilidad(@PathVariable("id") long id, @RequestBody ItemHabilidadDto itemHabilidadDto) {
        if (!itemHabSer.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ItemHabilidad itemHabilidad = itemHabSer.getOne(id).get();
        itemHabilidad.setHabilidad(itemHabilidadDto.getHabilidad());
        itemHabilidad.setPorcentaje(itemHabilidadDto.getPorcentaje());

        itemHabSer.agregarItemHabilidad(itemHabilidad);

        return new ResponseEntity(new Mensaje("experiencia actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarItemHabilidad(@PathVariable Long id) {
        itemHabSer.borrarItemHabilidad(id);
    }
}
