package com.web.springbootproject.repository.employee;

import com.web.springbootproject.entity.employee.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education,Long> {
}
