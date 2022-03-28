package com.maurote.portfolio.controller;

import com.maurote.portfolio.model.DatoPersonal;
import com.maurote.portfolio.model.Educacion;
import com.maurote.portfolio.model.EducacionDto;
import com.maurote.portfolio.model.Experiencia;
import com.maurote.portfolio.model.ExperienciaDto;
import com.maurote.portfolio.model.Habilidad;
import com.maurote.portfolio.model.Mensaje;
import com.maurote.portfolio.model.Proyecto;
import com.maurote.portfolio.service.IDatoPersonalService;
import com.maurote.portfolio.service.IEducacionService;
import com.maurote.portfolio.service.IExperienciaService;
import com.maurote.portfolio.service.IHabilidadService;
import com.maurote.portfolio.service.IProyectoService;
import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class Controller {
    @Autowired
    private IExperienciaService expServ;
    @Autowired
    private IEducacionService eduServ;
    @Autowired
    private IProyectoService proServ;
    @Autowired
    private IHabilidadService habServ;
    @Autowired
    private IDatoPersonalService datoPerSer;

    // ---------------------Datos Personales-------------------------------
    @PostMapping("/dato-personal/nuevo")
    public void agregarDatoPersonal(@RequestBody DatoPersonal datoPer) {
        datoPerSer.agregarDatoPersonal(datoPer);
    }

    @GetMapping("/dato-personal/listar")
    public List<DatoPersonal> listarDatoPersonal() {
        return datoPerSer.listarDatoPersonal();
    }

    // ---------------------Experiencia-------------------------------
    @PostMapping("/experiencia/nuevo")
    public void agregarExperiencia(@RequestBody Experiencia exp) {
        expServ.agregarExperiencia(exp);
    }

    @GetMapping("/experiencia/listar")
    public List<Experiencia> listarExperiencia() {
        return expServ.listarExperiencia();
    }

    @GetMapping("/experiencia/buscar/{id}")
    public ResponseEntity<Experiencia> obtenerPorId(@PathVariable("id") Long id) {
        if (!expServ.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = expServ.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    @PutMapping("/experiencia/editar/{id}")
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

    @DeleteMapping("/experiencia/borrar/{id}")
    public void borrarExperiencia(@PathVariable Long id) {
        expServ.borrarExperiencia(id);
    }

    // ---------------------Educacion-------------------------------
    @PostMapping("/educacion/nuevo")
    public void agregarEducacion(@RequestBody Educacion edu) {
        eduServ.agregarEducacion(edu);
    }

    @GetMapping("/educacion/listar")
    public List<Educacion> listarEducacion() {
        return eduServ.listarEducacion();
    }

    @DeleteMapping("/educacion/borrar/{id}")
    public void borrarEducacion(@PathVariable Long id) {
        eduServ.borrarEducacion(id);
    }

    @GetMapping("/educacion/buscar/{id}")
    public ResponseEntity<Educacion> obtenerEducacionPorId(@PathVariable("id") Long id) {
        if (!eduServ.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = eduServ.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PutMapping("/educacion/editar/{id}")
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

    // ---------------------Proyecto-------------------------------
    @PostMapping("/proyecto/nuevo")
    public void agregarProyecto(@RequestBody Proyecto pro) {
        proServ.agregarProyecto(pro);
    }

    @GetMapping("/proyecto/listar")
    public List<Proyecto> listarProyecto() {
        return proServ.listarProyecto();
    }

    // ---------------------Habilidad-------------------------------
    @PostMapping("/habilidad/nuevo")
    public void agregarProyecto(@RequestBody Habilidad hab) {
        habServ.agregarHabilidad(hab);
    }

    @GetMapping("/habilidad/listar")
    public List<Habilidad> listarHabilidad() {
        return habServ.listarHabilidad();
    }
}
