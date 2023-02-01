package com.web.springbootproject.repository.company;

import com.web.springbootproject.entity.company.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
