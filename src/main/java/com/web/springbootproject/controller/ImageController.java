package com.web.springbootproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.web.springbootproject.service.StorageService;

import java.io.IOException;

@RestController
@RequestMapping(path = "/api/v1/image")
public class ImageController {
    @Autowired
    private final StorageService storageService;

    public ImageController(StorageService storageService) {
        this.storageService = storageService;
    }
    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile image) throws IOException {
        String uploadImage = storageService.uploadImage(image);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping(path = "{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
        byte[] image = storageService.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }
}