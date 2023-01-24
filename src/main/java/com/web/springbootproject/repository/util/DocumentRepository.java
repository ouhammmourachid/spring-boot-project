package com.web.springbootproject.repository.util;

import com.web.springbootproject.entity.util.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,Long> {
}
