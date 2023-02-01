package com.web.springbootproject.controller.user;

import com.web.springbootproject.entity.employee.Profile;
import com.web.springbootproject.entity.user.User;
import com.web.springbootproject.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private final UserService userService;
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping(path = "register")
    public User registerUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
