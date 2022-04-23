package com.maurote.portfolio.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import com.maurote.portfolio.entity.Educacion;
import com.maurote.portfolio.entity.Imagen;
import com.maurote.portfolio.entity.Mensaje;
import com.maurote.portfolio.models.EducacionDto;
import com.maurote.portfolio.service.CloudinaryService;
import com.maurote.portfolio.service.IEducacionService;

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
@RequestMapping("/educacion")
public class EducacionController {
    @Autowired
    private IEducacionService eduServ;

    @Autowired
    CloudinaryService cloudinaryService;
    
    @PostMapping("/nuevo")
    public ResponseEntity agregarExperiencia(@RequestParam MultipartFile imagen,
            @RequestParam String objeto) throws IOException {

        // setear objeto
        JSONObject objetoJson = new JSONObject(objeto);
        Educacion edu = new Educacion();
        edu.setTitulo(objetoJson.getString("titulo"));
        edu.setPeriodo(objetoJson.getString("periodo"));
        edu.setTexto(objetoJson.getString("texto"));
        edu.setLugar(objetoJson.getString("lugar"));

        // imagen
        if (!imagen.isEmpty()) {
            BufferedImage bi = ImageIO.read(imagen.getInputStream());
            if (bi == null) {
                return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
            }

            // guardar imagen
            Map result = cloudinaryService.upload(imagen);

            // setear objeto
            Imagen nuevaImagen = new Imagen();
            nuevaImagen.setImagenId((String) result.get("public_id"));
            nuevaImagen.setImagenUrl((String) result.get("url"));
            nuevaImagen.setName((String) result.get("original_filename"));
            
            edu.setImagen(nuevaImagen);

        } else {
            // setear objeto
            Imagen nuevaImagen = new Imagen();
            nuevaImagen.setImagenId("");
            nuevaImagen.setImagenUrl("");
            nuevaImagen.setName("");
            edu.setImagen(nuevaImagen);
        }

        // guardar objeto
        eduServ.agregarEducacion(edu);

        return new ResponseEntity<>(new Mensaje("Actualizado"), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<Educacion> listarEducacion() {
        return eduServ.listarEducacion();
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarEducacion(@PathVariable Long id) {
        eduServ.borrarEducacion(id);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Educacion> obtenerEducacionPorId(@PathVariable("id") Long id) {
        if (!eduServ.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = eduServ.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
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
}
