package com.web.springbootproject.repository.user;

import com.web.springbootproject.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
