package com.web.springbootproject.repository.employee;

import com.web.springbootproject.entity.employee.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository<Skills,Long> {
}
