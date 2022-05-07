package com.maurote.portfolio.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import com.maurote.portfolio.entity.Mensaje;
import com.maurote.portfolio.entity.Proyecto;
import com.maurote.portfolio.service.IProyectoService;

import com.maurote.portfolio.service.CloudinaryService;

import org.cloudinary.json.JSONObject;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = {"${crossorigin.origin}"})
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    private IProyectoService proServ;

    @Autowired
    CloudinaryService cloudinaryService;

    @PostMapping("/nuevo")
    public ResponseEntity agregarExperiencia(@RequestParam MultipartFile imagen,
            @RequestParam String objeto) throws IOException {

        System.out.println(objeto);

        // setear objeto
        JSONObject objetoJson = new JSONObject(objeto);
        Proyecto proyecto = new Proyecto();
        proyecto.setNombreProyecto(objetoJson.getString("nombreProyecto"));
        proyecto.setPrograma(objetoJson.getString("programa"));
        proyecto.setRepositorioGit(objetoJson.getString("repositorioGit"));
        proyecto.setAnio(objetoJson.getString("anio"));
        proyecto.setTexto(objetoJson.getString("texto"));

        // imagen
        if (!imagen.isEmpty()) {
            BufferedImage bi = ImageIO.read(imagen.getInputStream());
            if (bi == null) {
                return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
            }

            // guardar imagen
            Map result = cloudinaryService.upload(imagen);

            // setear objeto
            proyecto.setImagenId((String) result.get("public_id"));
            proyecto.setImagenUrl((String) result.get("secure_url"));

        } else {
            // setear objeto
            proyecto.setImagenId("");
            proyecto.setImagenUrl("");
        }

        // guardar objeto
        proServ.agregarProyecto(proyecto);

        return new ResponseEntity<>(new Mensaje("Actualizado"), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Proyecto> obtenerPorId(@PathVariable("id") Long id) {
        if (!proServ.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = proServ.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<Proyecto> listarProyecto() {
        return proServ.listarProyecto();
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarProyecto(@PathVariable Long id) {
        if (!proServ.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        proServ.borrarProyecto(id);

        return new ResponseEntity<>(new Mensaje("Borrado correctamente"), HttpStatus.OK);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> update(@RequestParam MultipartFile imagen,
            @RequestParam String objeto,
            @RequestParam String quitarImagen) throws IOException {

        // setear objeto
        JSONObject objetoJson = new JSONObject(objeto);
        Map result;
        Long idObjeto = Long.parseLong(objetoJson.getString("id"));
        if (!proServ.existePorId(Long.parseLong(objetoJson.getString("id"))))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);

        Proyecto proyecto = proServ.getOne(idObjeto).get();
        proyecto.setNombreProyecto(objetoJson.getString("nombreProyecto"));
        proyecto.setPrograma(objetoJson.getString("programa"));
        proyecto.setTexto(objetoJson.getString("texto"));
        proyecto.setRepositorioGit(objetoJson.getString("repositorioGit"));
        proyecto.setAnio(objetoJson.getString("anio"));

        // si hay imagen en formulario recibido actualizar imagen en cloudinary y bd
        if (!imagen.isEmpty()) {
            BufferedImage bi = ImageIO.read(imagen.getInputStream());
            if (bi == null) {
                return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
            }

            // borrar imagen si antes habia
            if (!objetoJson.getString("imagenId").equals(""))
                result = cloudinaryService.delete(objetoJson.getString("imagenId"));

            // guardar nueva imagen en cloudinary
            result = cloudinaryService.upload(imagen);

            // actualizar campos de la imagen en db
            proyecto.setImagenId((String) result.get("public_id"));
            proyecto.setImagenUrl((String) result.get("secure_url"));

        } 
        else { 
            // si no hay imagen en formulario recibido comprobar si antes habia para borrarla
            if (!objetoJson.getString("imagenId").equals("") && quitarImagen.equals("true")) {
                result = cloudinaryService.delete(objetoJson.getString("imagenId"));
                proyecto.setImagenId("");
                proyecto.setImagenUrl("");
            }
        }

        // guardar objeto
        proServ.agregarProyecto(proyecto);

        return new ResponseEntity(new Mensaje("Actualizado correctamente"),HttpStatus.OK);
    }
    
}