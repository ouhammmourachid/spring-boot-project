package com.web.springbootproject.service;

import com.web.springbootproject.repository.StorageRepository;
import com.web.springbootproject.entity.FileData;
import com.web.springbootproject.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {
    @Autowired
    private final StorageRepository storageRepository;

    public StorageService(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    public String uploadImage(MultipartFile file) throws IOException {
        FileData imageData = storageRepository.save(
                FileData.builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .fileData(FileUtils.compressImage(file.getBytes()))
                        .build());

        if(imageData!=null){
            return "image uploaded successfully :"+file.getOriginalFilename();
        }
        return null;
    }
    public byte[] downloadImage(String fileName){
        Optional<FileData> imageData = storageRepository.findByName(fileName);
        byte[] file = FileUtils.decompressImage(imageData.get().getFileData());
        return file;
    }
}