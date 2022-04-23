package com.maurote.portfolio.service;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {
    Cloudinary cloudinary;

    @Value("${cloudinary.cloud-name}")
    private String cloud_name;
    @Value("${cloudinary.api-key}")
    private String apiKey;
    @Value("${cloudinary.api-secret}")
    private String apiSecret;

    private Map<String, String> valuesMap = new HashMap<>();

    public CloudinaryService() {
        System.out.println("cloud_name: " + cloud_name);
        System.out.println("apiKey: " + apiKey);
        System.out.println("apiSecret: " + apiSecret);
        valuesMap.put("cloud_name", "dpnsaly4k");
        valuesMap.put("api_key", "966561916368153");
        valuesMap.put("api_secret", "4-jOlkaiE0zaVeM-0jZNH8IdbkY");
        // valuesMap.put("cloud_name", "dpnsaly4k");
        // valuesMap.put("api_key", "966561916368153");
        // valuesMap.put("api_secret", "4-jOlkaiE0zaVeM-0jZNH8IdbkY");
        cloudinary = new Cloudinary(valuesMap);
    }

    public Map upload(MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return result;
    }

    public Map delete(String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        return result;
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fo = new FileOutputStream(file);
        fo.write(multipartFile.getBytes());
        fo.close();
        return file;
    }

}
