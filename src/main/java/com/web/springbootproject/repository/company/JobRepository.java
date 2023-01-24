package com.web.springbootproject.repository.company;

import com.web.springbootproject.entity.company.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
