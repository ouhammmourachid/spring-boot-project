package com.web.springbootproject.repository.employee;

import com.web.springbootproject.entity.employee.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language,Long> {
}
