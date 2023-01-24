package com.web.springbootproject.repository.company;

import com.web.springbootproject.entity.company.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application,Long> {
}
