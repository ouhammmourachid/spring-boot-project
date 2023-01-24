package com.web.springbootproject.repository.util;

import com.web.springbootproject.entity.util.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
