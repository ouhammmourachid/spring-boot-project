package com.web.springbootproject.service.user;

import com.web.springbootproject.entity.user.User;
import com.web.springbootproject.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
}
