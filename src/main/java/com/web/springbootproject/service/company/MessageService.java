package com.web.springbootproject.service.company;

import com.web.springbootproject.entity.company.Message;
import com.web.springbootproject.entity.user.User;
import com.web.springbootproject.exception.ResourceNotFoundException;
import com.web.springbootproject.repository.company.MessageRepository;
import com.web.springbootproject.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class MessageService {
    @Autowired
    private final MessageRepository messageRepository;
    @Autowired
    private final UserRepository userRepository;

    public List<Message> getAllMessage() {
        return messageRepository.findAll();
    }

    public Message addMessage(Long sendBy, Long receivedBy, Message message) {
        User sendByUser = userRepository.findById(sendBy)
                .orElseThrow(()->new ResourceNotFoundException("user with id [%s] not found.".formatted(sendBy)));
        User receivedByUser = userRepository.findById(receivedBy)
                .orElseThrow(()->new ResourceNotFoundException("user with id [%s] not found.".formatted(receivedBy)));
        message.setSendByUser(sendByUser);
        message.setReceivedByUser(receivedByUser);
        message.setCreatedDate(LocalDate.now());
        return messageRepository.save(message);
    }
}
