package com.web.springbootproject.controller.company;

import com.web.springbootproject.entity.company.Application;
import com.web.springbootproject.service.company.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/application")
@AllArgsConstructor
public class ApplicationController {
    @Autowired
    private final ApplicationService applicationService;
    @GetMapping
    public List<Application> getAllApplication(){
        return applicationService.getAllApplication();
    }
    @PostMapping
    public Application addApplication(@RequestParam Long userId,
                                      @RequestParam Long jobId){
        return applicationService.addApplication(userId,jobId);
    }
}
