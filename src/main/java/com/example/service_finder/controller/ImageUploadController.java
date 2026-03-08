package com.example.service_finder.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ImageUploadController {

    private static final String UPLOAD_DIR = "uploads/";

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("image") MultipartFile file) throws IOException {

        File folder = new File(UPLOAD_DIR);

        if(!folder.exists()){
            folder.mkdir();
        }

        String fileName = file.getOriginalFilename();

        File saveFile = new File(UPLOAD_DIR + fileName);

        file.transferTo(saveFile);

        return fileName;
    }
}
