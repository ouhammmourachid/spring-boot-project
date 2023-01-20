package com.web.springbootproject.service;

import com.web.springbootproject.repository.StorageRepository;
import com.web.springbootproject.entity.ImageData;
import com.web.springbootproject.util.ImageUtils;
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
        ImageData imageData = storageRepository.save(
                ImageData.builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .imageData(ImageUtils.compressImage(file.getBytes()))
                        .build());
        if(imageData!=null){
            return "image uploaded sucessfully :"+file.getOriginalFilename();
        }
        return null;
    }
    public byte[] downloadImage(String fileName){
        Optional<ImageData> imageData = storageRepository.findByName(fileName);
        byte[] image = ImageUtils.decompressImage(imageData.get().getImageData());
        return image;
    }
}