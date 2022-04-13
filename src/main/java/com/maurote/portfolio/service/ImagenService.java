package com.maurote.portfolio.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImagenService {
    //private String upload_folder = "." + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "files" + File.separator;
    private String upload_folder = ".//src//main//resources//files//";

    public void saveFile(MultipartFile file) throws IOException {

        if(!file.isEmpty()){
            byte[] bytes = file.getBytes();
            Path path = Paths.get(upload_folder + file.getOriginalFilename());
            Files.write(path,bytes);
        }
    }

}
