package com.web.springbootproject.repository.employee;

import com.web.springbootproject.entity.employee.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate,Long> {
}
