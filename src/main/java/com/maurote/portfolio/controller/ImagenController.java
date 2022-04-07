package com.maurote.portfolio.controller;

import com.maurote.portfolio.service.ImagenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping("/imagen")
@CrossOrigin("https://mauroperaltaportfolio.web.app")
public class ImagenController {
    @Autowired
    private ImagenService imagenService;

    @PostMapping("/subir")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<Object>("Seleccionar un archivo", HttpStatus.OK);
        }

        try {
            imagenService.saveFile(file);
            return new ResponseEntity<Object>("Imagen subida correctamente", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<Object>("Error al subir imagen", HttpStatus.BAD_REQUEST);
        }

    }

    // <InputStreamResource>
    @GetMapping("/ver")
    public ResponseEntity<?> getImagen(@RequestParam String nombre) throws IOException {

        String extension = nombre.split("\\.")[nombre.split("\\.").length - 1].toLowerCase();
        InputStreamSource imgFile = new ClassPathResource("files//" + nombre);

        if (extension.equals("jpg") || extension.equals("jpeg")) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                    .body(new InputStreamResource(imgFile.getInputStream()));
            //return new ResponseEntity<Object>(imgFile, HttpStatus.OK);
        } else if (extension.equals("gif")) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_GIF)
                    .body(new InputStreamResource(imgFile.getInputStream()));
        } else if (extension.equals("png")) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG)
                    .body(new InputStreamResource(imgFile.getInputStream()));
        } 

        return new ResponseEntity<Object>(imgFile, HttpStatus.OK);
    }
}
