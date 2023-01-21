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
@RequestMapping(path = "/api/v1/document")
public class DocumentController {
    @Autowired
    private final StorageService storageService;

    public DocumentController(StorageService storageService) {
        this.storageService = storageService;
    }
    @PostMapping
    public ResponseEntity<?> uploadDocument(@RequestParam("file")MultipartFile pdfFile) throws IOException {
        String uploadDocument = storageService.uploadFile(pdfFile);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadDocument);
    }

    @GetMapping(path = "{fileName}")
    public ResponseEntity<?> downloadDocument(@PathVariable String fileName){
        byte[] file = storageService.downloadFile(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_PDF)
                .body(file);
    }
}