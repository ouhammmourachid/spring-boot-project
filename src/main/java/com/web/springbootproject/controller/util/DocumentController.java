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
@RequestMapping(path = "/api/v1")
@AllArgsConstructor
public class DocumentController {
    @Autowired
    private final StorageService storageService;

    @PostMapping(path = "user/document")
    public ResponseEntity<?> uploadDocument(@RequestParam Long id,
                                            @RequestParam MultipartFile file,
                                            @RequestParam String name) throws IOException {
        String response = storageService.uploadDocument(id,file,name);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
    @GetMapping(path = "document/{id}")
    public ResponseEntity<?> downloadDocument(@PathVariable Long id){
        byte[] file = storageService.downloadFile(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_PDF)
                .body(file);
    }
}