package com.web.springbootproject.repository.util;

import com.web.springbootproject.entity.util.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<FileData,Long> {

}