package com.web.springbootproject.repository;

import com.web.springbootproject.entity.util.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<FileData,Long> {
    Optional<FileData> findByName(String fileName);
}