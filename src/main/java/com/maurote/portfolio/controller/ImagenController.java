package com.maurote.portfolio.controller;

import com.maurote.portfolio.entity.Imagen;
import com.maurote.portfolio.entity.Mensaje;
import com.maurote.portfolio.service.CloudinaryService;
import com.maurote.portfolio.service.ImagenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/imagen")
@CrossOrigin(origins = { "${crossorigin.origin}" })
public class ImagenController {

    @Autowired
    CloudinaryService cloudinaryService;

    @PostMapping("/subir")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile) throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if (bi == null) {
            return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.upload(multipartFile);

        Imagen imagen = new Imagen(
                (String) result.get("original_filename"),
                (String) result.get("url"),
                (String) result.get("public_id"));
        return new ResponseEntity(imagen, HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) throws IOException {
        Map result = cloudinaryService.delete(id);
        return new ResponseEntity(new Mensaje("imagen eliminada"), HttpStatus.OK);
    }

}

/*
 * import java.io.File;
 * import java.io.IOException;
 * 
 * import com.maurote.portfolio.service.CloudinaryService;
 * import com.maurote.portfolio.service.ImagenService;
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.core.io.ClassPathResource;
 * import org.springframework.core.io.InputStreamResource;
 * import org.springframework.core.io.InputStreamSource;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.http.MediaType;
 * import org.springframework.http.ResponseEntity;
 * import org.springframework.stereotype.Controller;
 * import org.springframework.web.bind.annotation.CrossOrigin;
 * import org.springframework.web.bind.annotation.GetMapping;
 * import org.springframework.web.bind.annotation.PostMapping;
 * import org.springframework.web.bind.annotation.RequestMapping;
 * import org.springframework.web.bind.annotation.RequestParam;
 * import org.springframework.web.multipart.MultipartFile;
 * 
 * @Controller
 * 
 * @RequestMapping("/imagen")
 * 
 * @CrossOrigin(origins = {"${crossorigin.origin}"})
 * public class ImagenController {
 * 
 * @Autowired
 * CloudinaryService cloudinaryService;
 * 
 * @Autowired
 * private ImagenService imagenService;
 * 
 * @PostMapping("/subir")
 * public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file)
 * {
 * InputStreamSource imgFile = new ClassPathResource("files" + File.separator +
 * "nombre.png");
 * 
 * if (file.isEmpty())
 * return new ResponseEntity<Object>("Seleccionar un archivo", HttpStatus.OK);
 * 
 * if (file.getContentType().equals("image/jpeg") ||
 * file.getContentType().equals("image/png") ||
 * file.getContentType().equals("image/gif")) {
 * try {
 * //File files = new File("src" + File.separator + "main" + File.separator +
 * "resources" + File.separator + "files");
 * //if (!files.exists()) files.mkdirs();
 * 
 * imagenService.saveFile(file);
 * return new ResponseEntity<Object>("Imagen subida correctamente",
 * HttpStatus.OK);
 * } catch (IOException e) {
 * e.printStackTrace();
 * 
 * try {
 * return new ResponseEntity<Object>("Error al subir imagen " + e.getMessage() +
 * ", url: " + (new InputStreamResource(imgFile.getInputStream())).getURL(),
 * HttpStatus.BAD_REQUEST);
 * } catch (IOException e1) {
 * e1.printStackTrace();
 * }
 * 
 * return new ResponseEntity<Object>("Error al subir imagen " + e.getMessage(),
 * HttpStatus.BAD_REQUEST);
 * }
 * } else {
 * return new ResponseEntity<Object>("Tipo de imagen no reconocida",
 * HttpStatus.BAD_REQUEST);
 * }
 * 
 * }
 * 
 * // <InputStreamResource>
 * 
 * @GetMapping("/ver")
 * public ResponseEntity<?> getImagen(@RequestParam String nombre) throws
 * IOException {
 * 
 * String extension = nombre.split("\\.")[nombre.split("\\.").length -
 * 1].toLowerCase();
 * InputStreamSource imgFile = new ClassPathResource("files" + File.separator +
 * nombre);
 * (new InputStreamResource(imgFile.getInputStream())).getURL();
 * 
 * if (extension.equals("jpg") || extension.equals("jpeg")) {
 * return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
 * .body(new InputStreamResource(imgFile.getInputStream()));
 * // return new ResponseEntity<Object>(imgFile, HttpStatus.OK);
 * } else if (extension.equals("gif")) {
 * return ResponseEntity.ok().contentType(MediaType.IMAGE_GIF)
 * .body(new InputStreamResource(imgFile.getInputStream()));
 * } else if (extension.equals("png")) {
 * return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG)
 * .body(new InputStreamResource(imgFile.getInputStream()));
 * } else {
 * return ResponseEntity.badRequest().body("Error en tipo de imagen");
 * }
 * 
 * 
 * }
 * }
 */
