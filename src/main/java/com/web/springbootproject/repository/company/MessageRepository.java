package com.web.springbootproject.repository.company;

import com.web.springbootproject.entity.company.Message;
import com.web.springbootproject.entity.company.embadded.MessageId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, MessageId> {
}
