package com.web.springbootproject.service.employee;

import com.web.springbootproject.entity.employee.Profile;
import com.web.springbootproject.entity.employee.Skills;
import com.web.springbootproject.exception.RequestValidationException;
import com.web.springbootproject.exception.ResourceNotFoundException;
import com.web.springbootproject.repository.employee.ProfileRepository;
import com.web.springbootproject.repository.employee.SkillsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class SkillsService {
    @Autowired
    private final SkillsRepository skillsRepository;
    @Autowired
    private final ProfileRepository profileRepository;
    public List<Skills> getAllSkills(){
        return skillsRepository.findAll();
    }
    public Optional<Skills> getSkills(Long id){
        return skillsRepository.findById(id);
    }
    public List<Skills> addSkills(Long profileId,Skills skills){
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(()-> new ResourceNotFoundException("profile with id [%s] not found .".formatted(profileId)));
        if( skills.getLabel() != null && skills.getSince() != null){
            profile.getSkills().add(skills);
            profileRepository.save(profile);
        }
        return profile.getSkills() ;
    }
    public Skills updateSkills(Long id,Skills updateRequest){
        Skills skills = skillsRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("skills with id [%s] not found .".formatted(id)));
        boolean changed = false ;
        if(updateRequest.getLabel() != null  && !updateRequest.getLabel().equals(skills.getLabel())){
            skills.setLabel(updateRequest.getLabel());
            changed = true;
        }
        if(updateRequest.getSince() != null && !updateRequest.getSince().equals(skills.getSince())){
            skills.setSince(updateRequest.getSince());
            changed = true;
        }
        if(!changed){
            throw new RequestValidationException("no data changes found");
        }
        skillsRepository.save(skills);
        return skills;
    }

    public void deleteSkills(Long id) {
        skillsRepository.deleteById(id);
    }
}
