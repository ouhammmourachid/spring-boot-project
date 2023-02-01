package com.web.springbootproject.repository.employee;

import com.web.springbootproject.entity.employee.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
}
