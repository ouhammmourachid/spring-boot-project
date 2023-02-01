package com.web.springbootproject.controller.employee;

import com.web.springbootproject.entity.employee.Education;
import com.web.springbootproject.entity.employee.Skills;
import com.web.springbootproject.service.employee.SkillsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/skills")
public class SkillsController {
    @Autowired
    private final SkillsService skillsService;
    @GetMapping
    public List<Skills> getAllSkills(){
        return skillsService.getAllSkills();
    }
    @GetMapping(path = "{id}")
    public Optional<Skills> getSkills(@PathVariable Long id){
        return skillsService.getSkills(id);
    }
    @PostMapping
    public List<Skills> addSkills(@RequestParam Long profileId,
                                          @RequestBody Skills skills){
        return  skillsService.addSkills(profileId, skills);
    }
    @PutMapping(path = "{id}")
    public Skills updateSkills(@PathVariable Long id,
                                       @RequestBody Skills updateRequest){
        return skillsService.updateSkills(id, updateRequest);
    }
    @DeleteMapping(path = "{id}")
    public void deleteSkills(@PathVariable Long id){
        skillsService.deleteSkills(id);
    }
}
