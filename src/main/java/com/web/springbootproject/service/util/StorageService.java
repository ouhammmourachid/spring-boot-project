package com.web.springbootproject.service.util;

import com.web.springbootproject.entity.company.Company;
import com.web.springbootproject.entity.company.Job;
import com.web.springbootproject.entity.user.User;
import com.web.springbootproject.entity.util.Document;
import com.web.springbootproject.entity.util.FileData;
import com.web.springbootproject.entity.util.Image;
import com.web.springbootproject.exception.ResourceNotFoundException;
import com.web.springbootproject.repository.company.CompanyRepository;
import com.web.springbootproject.repository.company.JobRepository;
import com.web.springbootproject.repository.user.UserRepository;
import com.web.springbootproject.repository.util.DocumentRepository;
import com.web.springbootproject.repository.util.ImageRepository;
import com.web.springbootproject.repository.util.StorageRepository;
import com.web.springbootproject.util.FileUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StorageService {
    @Autowired
    private final StorageRepository storageRepository;
    @Autowired
    private final ImageRepository imageRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final DocumentRepository documentRepository;
    @Autowired
    private final JobRepository jobRepository;
    public String uploadUserImage(Long userId,MultipartFile file,String name) throws IOException {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("user with id [%s] not found .".formatted(userId)));
        FileData imageData = storageRepository.save(
                FileData.builder()
                        .fileData(FileUtils.compressImage(file.getBytes()))
                        .build());
        Image image = Image.builder()
                .name(name)
                .fileDataId(imageData.getId())
                .type(file.getContentType())
                .build();
        image.setUser(user);
        user.setImage(image);
        imageRepository.save(image);
        userRepository.save(user);
        if(image!=null){
            return "image uploaded successfully ";
        }
        return null;
    }
    public byte[] downloadFile(Long id){
        Optional<FileData> imageData = storageRepository.findById(id);
        byte[] file = FileUtils.decompressImage(imageData.get().getFileData());
        return file;
    }
    public String uploadDocument(Long id, MultipartFile file,String name)throws IOException{
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("user with id [%s] not found .".formatted(id)));
        FileData fileData = storageRepository.save(
                FileData.builder()
                        .fileData(FileUtils.compressImage(file.getBytes()))
                        .build());
        Document document= Document.builder()
                .name(name)
                .type(file.getContentType())
                .fileDataId(fileData.getId())
                .build();
        document.setUser(user);
        user.setDocument(document);
        documentRepository.save(document);
        userRepository.save(user);
        if(document!=null){
            return "Document uploaded successfully ";
        }
        return null;
    }

    public String uploadJobImage(Long jobId, MultipartFile file, String name) throws IOException{
        Job job = jobRepository.findById(jobId)
                .orElseThrow(()-> new ResourceNotFoundException("job with id [%s] not found .".formatted(jobId)));
        FileData imageData = storageRepository.save(
                FileData.builder()
                        .fileData(FileUtils.compressImage(file.getBytes()))
                        .build());
        Image image = Image.builder()
                .name(name)
                .fileDataId(imageData.getId())
                .type(file.getContentType())
                .build();
        image.setJob(job);
        job.setImage(image);
        imageRepository.save(image);
        jobRepository.save(job);
        if(image!=null){
            return "image uploaded successfully ";
        }
        return null;
    }
}