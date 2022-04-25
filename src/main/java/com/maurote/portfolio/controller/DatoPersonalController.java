package com.maurote.portfolio.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import com.maurote.portfolio.entity.DatoPersonal;
import com.maurote.portfolio.entity.Imagen;
import com.maurote.portfolio.entity.Mensaje;
import com.maurote.portfolio.service.CloudinaryService;
import com.maurote.portfolio.service.IDatoPersonalService;
import com.maurote.portfolio.service.ImagenService;

import org.cloudinary.json.JSONObject;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = { "${crossorigin.origin}" })
@RequestMapping("/dato-personal")
public class DatoPersonalController {

    @Autowired
    private IDatoPersonalService datoPerSer;

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImagenService imagenService;

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

    @PutMapping("/editar")
    public ResponseEntity<?> update(
            @RequestParam MultipartFile imagenPerfil,
            @RequestParam MultipartFile imagenPortada,
            @RequestParam String objeto,
            @RequestParam String imagenPerfilId,
            @RequestParam String imagenPortadaId,
            @RequestParam String quitarImagenPerfil,
            @RequestParam String quitarImagenPortada) throws IOException {

        System.out.println(objeto);
        // setear objeto
        JSONObject objetoJson = new JSONObject(objeto);
        int idImagenPerfil = Integer.parseInt(imagenPerfilId);
        int idImagenPortada = Integer.parseInt(imagenPortadaId);

        Map resultPerfil;
        Map resultPortada;
        Long idObjeto = 1L;
        if (!datoPerSer.existePorId(idObjeto))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);

        DatoPersonal datoPersonal = datoPerSer.getOne(idObjeto).get();
        datoPersonal.setNombre(objetoJson.getString("nombre"));
        datoPersonal.setProfesion(objetoJson.getString("profesion"));
        datoPersonal.setTexto(objetoJson.getString("texto"));
        datoPersonal.setUrlFacebook(objetoJson.getString("urlFacebook"));
        datoPersonal.setUrlGitHub(objetoJson.getString("urlGitHub"));

        Imagen nuevaImagenPerfil = imagenService.getOne(idImagenPerfil).get();
        Imagen nuevaImagenPortada = imagenService.getOne(idImagenPortada).get();

        // -------------------------------------------- imagen perfil
        // -------------------------------------------------------
        // si hay imagen en formulario recibido actualizar imagen en cloudinary y bd
        if (!imagenPerfil.isEmpty()) {
            BufferedImage biPerfil = ImageIO.read(imagenPerfil.getInputStream());
            if (biPerfil == null) {
                return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
            }

            // borrar imagen si antes habia
            if (!nuevaImagenPerfil.getImagenId().equals(""))
                resultPerfil = cloudinaryService.delete(nuevaImagenPerfil.getImagenId());

            // guardar nueva imagen en cloudinary
            resultPerfil = cloudinaryService.upload(imagenPerfil);

            // actualizar campos de la imagen en db
            nuevaImagenPerfil.setImagenId((String) resultPerfil.get("public_id"));
            nuevaImagenPerfil.setImagenUrl((String) resultPerfil.get("url"));
            nuevaImagenPerfil.setName((String) resultPerfil.get("original_filename"));

            // guardar imagen en la entidad padre
            datoPersonal.setImagenPerfil(nuevaImagenPerfil);

        } else if (imagenPerfil.isEmpty()) {
            // si no hay imagen en formulario recibido comprobar si antes habia para
            // borrarla
            if (!nuevaImagenPerfil.getImagenId().equals("") && quitarImagenPerfil.equals("true")) {
                resultPerfil = cloudinaryService.delete(nuevaImagenPerfil.getImagenId());
                nuevaImagenPerfil.setImagenId("");
                nuevaImagenPerfil.setImagenUrl("");
                nuevaImagenPerfil.setName("");

                // guardar imagen en la entidad padre
                datoPersonal.setImagenPerfil(nuevaImagenPerfil);
            }
        }
        // --------Fin imagen perfil ------------------------//

        // -------- imagen portada -------------------------//
        // si hay imagen en formulario recibido actualizar imagen en cloudinary y bd
        if (!imagenPortada.isEmpty()) {
            BufferedImage biPortada = ImageIO.read(imagenPortada.getInputStream());
            if (biPortada == null) {
                return new ResponseEntity(new Mensaje("imagen portada no válida"), HttpStatus.BAD_REQUEST);
            }

            // borrar imagen si antes habia
            if (!nuevaImagenPortada.getImagenId().equals(""))
                resultPortada = cloudinaryService.delete(nuevaImagenPortada.getImagenId());

            // guardar nueva imagen en cloudinary
            resultPortada = cloudinaryService.upload(imagenPortada);

            // actualizar campos de la imagen en db
            nuevaImagenPortada.setImagenId((String) resultPortada.get("public_id"));
            nuevaImagenPortada.setImagenUrl((String) resultPortada.get("url"));
            nuevaImagenPortada.setName((String) resultPortada.get("original_filename"));

            // guardar imagen en la entidad padre
            datoPersonal.setImagenPortada(nuevaImagenPortada);

        } else if (imagenPortada.isEmpty()) {
            // si no hay imagen en formulario recibido comprobar si antes habia para
            // borrarla
            if (!nuevaImagenPortada.getImagenId().equals("") && quitarImagenPortada.equals("true")) {
                resultPortada = cloudinaryService.delete(nuevaImagenPortada.getImagenId());
                nuevaImagenPortada.setImagenId("");
                nuevaImagenPortada.setImagenUrl("");
                nuevaImagenPortada.setName("");

                // guardar imagen en la entidad padre
                datoPersonal.setImagenPortada(nuevaImagenPortada);
            }
        }
        // ---------- Fin imagen portada -----------------------//

        // guardar objeto
        datoPerSer.agregarDatoPersonal(datoPersonal);

        return new ResponseEntity(new Mensaje("Actualizado correctamente"), HttpStatus.OK);
    }

    /*
     * @PutMapping("/editar/{id}")
     * public ResponseEntity<?> updateEducacion(@PathVariable("id") long id,
     * 
     * @RequestBody DatoPersonalDto datoPersonalDto) {
     * if (!datoPerSer.existePorId(id))
     * return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
     * DatoPersonal datoPersonal = datoPerSer.getOne(id).get();
     * datoPersonal.setNombre(datoPersonalDto.getNombre());
     * datoPersonal.setProfesion(datoPersonalDto.getProfesion());
     * datoPersonal.setTexto(datoPersonalDto.getTexto());
     * datoPersonal.setUrlFacebook(datoPersonalDto.getUrlFacebook());
     * datoPersonal.setUrlGitHub(datoPersonalDto.getUrlGitHub());
     * 
     * datoPerSer.agregarDatoPersonal(datoPersonal);
     * 
     * return new ResponseEntity(new Mensaje("dato personal actualizado"),
     * HttpStatus.OK);
     * }
     */

}
