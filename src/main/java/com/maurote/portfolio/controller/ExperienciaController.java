package com.maurote.portfolio.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.persistence.Entity;

import com.maurote.portfolio.entity.Experiencia;
import com.maurote.portfolio.entity.Imagen;
import com.maurote.portfolio.entity.Mensaje;
import com.maurote.portfolio.models.ExperienciaDto;
import com.maurote.portfolio.service.CloudinaryService;
import com.maurote.portfolio.service.IExperienciaService;
import com.maurote.portfolio.service.ImagenService;

import org.apache.tomcat.util.json.JSONParser;
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
@CrossOrigin(origins = { "${crossorigin.origin}" })
@RequestMapping("/experiencia")
public class ExperienciaController {
    @Autowired
    private IExperienciaService expServ;

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImagenService imagenService;

    @PostMapping("/nuevo")
    public ResponseEntity agregarExperiencia(@RequestParam MultipartFile imagen,
            @RequestParam String objeto) throws IOException {

        // setear objeto
        JSONObject objetoJson = new JSONObject(objeto);
        Experiencia exp = new Experiencia();
        exp.setTitulo(objetoJson.getString("titulo"));
        exp.setPeriodo(objetoJson.getString("periodo"));
        exp.setTexto(objetoJson.getString("texto"));
        exp.setLugar(objetoJson.getString("lugar"));

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

            exp.setImagen(nuevaImagen);

        } else {
            // setear objeto
            Imagen nuevaImagen = new Imagen();
            nuevaImagen.setImagenId("");
            nuevaImagen.setImagenUrl("");
            nuevaImagen.setName("");
            exp.setImagen(nuevaImagen);
        }

        // guardar objeto
        expServ.agregarExperiencia(exp);

        return new ResponseEntity<>(new Mensaje("Actualizado"), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<Experiencia> listarExperiencia() {
        return expServ.listarExperiencia();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Experiencia> obtenerPorId(@PathVariable("id") Long id) {
        if (!expServ.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = expServ.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    /*
     * @PutMapping("/editar/{id}")
     * public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody
     * ExperienciaDto experienciaDto) {
     * if (!expServ.existePorId(id))
     * return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
     * Experiencia experiencia = expServ.getOne(id).get();
     * experiencia.setLugar(experienciaDto.getLugar());
     * experiencia.setPeriodo(experienciaDto.getPeriodo());
     * experiencia.setTexto(experienciaDto.getTexto());
     * experiencia.setTitulo(experienciaDto.getTitulo());
     * // experiencia.setUrlImagen(experienciaDto.getUrlImagen());
     * // experiencia.getsetIdImagen(experienciaDto.getImagen());
     * 
     * expServ.agregarExperiencia(experiencia);
     * 
     * return new ResponseEntity(new Mensaje("experiencia actualizado"),
     * HttpStatus.OK);
     * }
     */

    @PutMapping("/editar")
    public ResponseEntity<?> update(@RequestParam MultipartFile imagen,
            @RequestParam String objeto,
            @RequestParam String imagenId,
            @RequestParam String quitarImagen) throws IOException {

        // setear objeto
        JSONObject objetoJson = new JSONObject(objeto);
        int idImagen = Integer.parseInt(imagenId);
        Map result;
        Long idObjeto = Long.parseLong(objetoJson.getString("id"));
        if (!expServ.existePorId(Long.parseLong(objetoJson.getString("id"))))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);

        Experiencia exp = expServ.getOne(idObjeto).get();
        exp.setTitulo(objetoJson.getString("titulo"));
        exp.setPeriodo(objetoJson.getString("periodo"));
        exp.setTexto(objetoJson.getString("texto"));
        exp.setLugar(objetoJson.getString("lugar"));

        // imagen
        Imagen nuevaImagen = imagenService.getOne(idImagen).get();

        // si hay imagen en formulario recibido actualizar imagen en cloudinary y bd
        if (!imagen.isEmpty()) {
            BufferedImage bi = ImageIO.read(imagen.getInputStream());
            if (bi == null) {
                return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
            }

            // borrar imagen si antes habia
            if (!nuevaImagen.getImagenId().equals(""))
                result = cloudinaryService.delete(nuevaImagen.getImagenId());

            // guardar nueva imagen en cloudinary
            result = cloudinaryService.upload(imagen);

            // actualizar campos de la imagen en db
            nuevaImagen.setImagenId((String) result.get("public_id"));
            nuevaImagen.setImagenUrl((String) result.get("url"));
            nuevaImagen.setName((String) result.get("original_filename"));

            // guardar imagen en la entidad padre
            exp.setImagen(nuevaImagen);

        } 
        else { 
            // si no hay imagen en formulario recibido comprobar si antes habia para borrarla
            if (!nuevaImagen.getImagenId().equals("") && quitarImagen.equals("true")) {
                result = cloudinaryService.delete(nuevaImagen.getImagenId());
                nuevaImagen.setImagenId("");
                nuevaImagen.setImagenUrl("");
                nuevaImagen.setName("");
            }
        }

        // guardar objeto
        expServ.agregarExperiencia(exp);

        return new ResponseEntity(new Mensaje("Actualizado correctamente"),HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarExperiencia(@PathVariable Long id) {
        expServ.borrarExperiencia(id);
    }

    @DeleteMapping("/borrar-objeto/{id}")
    public void borrarExperienciaPorObjeto(@PathVariable Long id) {
        Experiencia experiencia = expServ.getOne(id).get();
        expServ.borrarPorObjeto(experiencia);
    }
}
