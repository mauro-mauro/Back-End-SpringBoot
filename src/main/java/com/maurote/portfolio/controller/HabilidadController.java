package com.maurote.portfolio.controller;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.maurote.portfolio.entity.GrupoHabilidad;
import com.maurote.portfolio.entity.Habilidad;
import com.maurote.portfolio.entity.Mensaje;
import com.maurote.portfolio.models.HabilidadDto;
import com.maurote.portfolio.models.ListaHabilidad;
import com.maurote.portfolio.repository.GrupoHabilidadRepository;
import com.maurote.portfolio.service.IGrupoHabilidadService;
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

    @Autowired
    private IGrupoHabilidadService grupoHabServ;

    // ---------------------Item Habilidad-------------------------------
    @GetMapping("/listar")
    public List<?> listarItemHabilidad() {
        List<ListaHabilidad> lista = new ArrayList();
        List<GrupoHabilidad> listaGrupoHabilidad = grupoHabServ.listarGrupoHabilidad();
        for(GrupoHabilidad temp : listaGrupoHabilidad){
            ListaHabilidad listaHabilidad = new ListaHabilidad();
            listaHabilidad.setId(temp.getId());
            listaHabilidad.setGrupoHabilidad(temp.getGrupoHabilidad());
            listaHabilidad.setHabilidades(habilidadSer.search(temp.getId()));
            lista.add(listaHabilidad);
        }
        return lista;
    }

    @GetMapping("/lista/buscar/{id}")
    public ResponseEntity<?> listaGrupo(@PathVariable("id") Long id){        

        return new ResponseEntity(habilidadSer.search(id), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Habilidad> buscar(@PathVariable("id") Long id){
        if (!habilidadSer.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Habilidad habilidad = habilidadSer.getOne(id).get();

        return new ResponseEntity(habilidad, HttpStatus.OK);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> agregarHabilidad(@RequestBody HabilidadDto habilidadDto) {
        Habilidad habilidad = new Habilidad();
        habilidad.setHabilidad(habilidadDto.getHabilidad());
        habilidad.setPorcentaje(habilidadDto.getPorcentaje());
        habilidad.setId_grupoHabilidad(grupoHabServ.findByGrupoHabilidadContaining(habilidadDto.getGrupoHabilidad()).get().getId());
        // System.out.println("Id: " + grupoHabRepo.findByGrupoHabilidadContaining("Web").get().getId());
        // System.out.println("Grupo Habilidad: " + grupoHabRepo.findByGrupoHabilidadContaining("Web").get().getGrupoHabilidad());
        
        habilidadSer.agregarHabilidad(habilidad);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> updateItemHabilidad(@PathVariable("id") long id, @RequestBody HabilidadDto habilidadDto) {
        if (!habilidadSer.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Habilidad habilidad = habilidadSer.getOne(id).get();
        habilidad.setHabilidad(habilidadDto.getHabilidad());
        habilidad.setPorcentaje(habilidadDto.getPorcentaje());

        habilidadSer.agregarHabilidad(habilidad);

        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarItemHabilidad(@PathVariable Long id) {
        habilidadSer.borrarHabilidad(id);
    }

    @DeleteMapping("/con-grupo-habilidad/borrar/{grupoHabilidad}")
    @Transactional
    public ResponseEntity<?> borrarItemHabilidadConGrupoHabilidad(@PathVariable String grupoHabilidad) {
        GrupoHabilidad grupoHab = grupoHabServ.findByGrupoHabilidadContaining(grupoHabilidad).get();
        grupoHabServ.borrarGrupoHabilidadPorObjeto(grupoHab);
        Long idGrupoHabilidadBorrar = grupoHab.getId();
        
        habilidadSer.borrarConGrupoDeHabilidad(idGrupoHabilidadBorrar);
        
        return new ResponseEntity(new Mensaje("Borrado correctamente"), HttpStatus.OK);
    }
}
