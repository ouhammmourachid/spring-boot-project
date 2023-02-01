package com.web.springbootproject.controller.employee;

import com.web.springbootproject.entity.employee.Certificate;
import com.web.springbootproject.entity.employee.Education;
import com.web.springbootproject.service.employee.EducationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/education")
public class EducationController {
    @Autowired
    private final EducationService educationService;
    @GetMapping
    public List<Education> getAllEduction(){
        return educationService.getAllEducation();
    }
    @GetMapping(path = "{id}")
    public Optional<Education> getEducation(@PathVariable Long id){
        return educationService.getEducation(id);
    }
    @PostMapping
    public List<Education> addEducation(@RequestParam Long profileId,
                                            @RequestBody Education education){
        return  educationService.addEducation(profileId,education);
    }
    @PutMapping(path = "{id}")
    public Education updateEducation(@PathVariable Long id,
                                         @RequestBody Education updateRequest){
        return educationService.updateEducation(id,updateRequest);
    }
    @DeleteMapping(path = "{id}")
    public void deleteEducation(@PathVariable Long id){
        educationService.deleteEducation(id);
    }
}
