package com.web.springbootproject.controller.company;

import com.web.springbootproject.entity.company.Message;
import com.web.springbootproject.service.company.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/message")
public class MessageController {
    @Autowired
    private final MessageService messageService;
    @GetMapping
    public List<Message> getAllMessage(){
        return messageService.getAllMessage();
    }
    @PostMapping
    public Message addMessage(@RequestParam Long sendBy,
                              @RequestParam Long receivedBy,
                              @RequestBody Message message){
        return messageService.addMessage(sendBy,receivedBy,message);
    }
}
