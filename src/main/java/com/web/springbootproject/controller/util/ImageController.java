package com.web.springbootproject.controller.util;

import com.web.springbootproject.service.util.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1")
public class ImageController {
    @Autowired
    private final StorageService storageService;

    @PostMapping(path = "user/image")
    public ResponseEntity<?> uploadUserImage(@RequestParam Long userId,
                                         @RequestParam MultipartFile image,
                                         @RequestParam String name) throws IOException {
        String uploadImage = storageService.uploadUserImage(userId,image,name);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }
    @PostMapping(path = "job/image")
    public ResponseEntity<?> uploadJobImage(@RequestParam Long jobId,
                                         @RequestParam MultipartFile image,
                                         @RequestParam String name) throws IOException {
        String uploadImage = storageService.uploadJobImage(jobId,image,name);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping(path = "image/{id}")
    public ResponseEntity<?> downloadImage(@PathVariable Long id){
        byte[] image = storageService.downloadFile(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }

}