package com.web.springbootproject.repository.employee;

import com.web.springbootproject.entity.employee.License;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepository extends JpaRepository<License,Long> {
}
