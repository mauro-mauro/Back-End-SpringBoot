package com.maurote.portfolio.controller;

import com.maurote.portfolio.model.DatoPersonal;
import com.maurote.portfolio.model.Educacion;
import com.maurote.portfolio.model.Experiencia;
import com.maurote.portfolio.model.Habilidad;
import com.maurote.portfolio.model.Proyecto;
import com.maurote.portfolio.service.IDatoPersonalService;
import com.maurote.portfolio.service.IEducacionService;
import com.maurote.portfolio.service.IExperienciaService;
import com.maurote.portfolio.service.IHabilidadService;
import com.maurote.portfolio.service.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    //---------------------Datos Personales-------------------------------
    @PostMapping("/dato-personal/nuevo")
    public void agregarDatoPersonal(@RequestBody DatoPersonal datoPer){
        datoPerSer.agregarDatoPersonal(datoPer);
    }
    
    @GetMapping("/dato-personal/listar")
    public List<DatoPersonal> listarDatoPersonal(){
        return datoPerSer.listarDatoPersonal();
    }
        
    //---------------------Experiencia-------------------------------
    @PostMapping("/experiencia/nuevo")
    public void agregarExperiencia(@RequestBody Experiencia exp){
        expServ.agregarExperiencia(exp);
    }
    
    
    @GetMapping("/experiencia/listar")
    @CrossOrigin(origins = "*")
    public List<Experiencia> listarExperiencia(){
        return expServ.listarExperiencia();
    }
    
    //---------------------Educacion-------------------------------
    @PostMapping("/educacion/nuevo")
    public void agregarEducacion(@RequestBody Educacion edu){
        eduServ.agregarEducacion(edu);
    }
    
    @GetMapping("/educacion/listar")
    public List<Educacion> listarEducacion(){
        return eduServ.listarEducacion();
    }
    
    //---------------------Proyecto-------------------------------
    @PostMapping("/proyecto/nuevo")
    public void agregarProyecto(@RequestBody Proyecto pro){
        proServ.agregarProyecto(pro);
    }
    
    @GetMapping("/proyecto/listar")
    public List<Proyecto> listarProyecto(){
        return proServ.listarProyecto();
    }
    
    //---------------------Habilidad-------------------------------
    @PostMapping("/habilidad/nuevo")
    public void agregarProyecto(@RequestBody Habilidad hab){
        habServ.agregarHabilidad(hab);
    }
    
    @GetMapping("/habilidad/listar")
    public List<Habilidad> listarHabilidad(){
        return habServ.listarHabilidad();
    }
}
