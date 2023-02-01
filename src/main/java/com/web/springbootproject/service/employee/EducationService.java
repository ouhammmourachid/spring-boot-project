package com.web.springbootproject.service.employee;

import com.web.springbootproject.entity.employee.Education;
import com.web.springbootproject.entity.employee.Profile;
import com.web.springbootproject.exception.RequestValidationException;
import com.web.springbootproject.exception.ResourceNotFoundException;
import com.web.springbootproject.repository.employee.EducationRepository;
import com.web.springbootproject.repository.employee.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class EducationService {
    @Autowired
    private final EducationRepository educationRepository;
    @Autowired
    private final ProfileRepository profileRepository;
    public List<Education> getAllEducation(){
        return educationRepository.findAll();
    }
    public Optional<Education> getEducation(Long id){
        return educationRepository.findById(id);
    }
    public List<Education> addEducation(Long profileId,Education education){
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(()-> new ResourceNotFoundException("profile with id [%s] not found .".formatted(profileId)));
        if(education.getEducationLevel()!=null){
            profile.getEducations().add(education);
            profileRepository.save(profile);
        }
        return profile.getEducations() ;
    }
    public Education updateEducation(Long id ,Education updateRequest){
        Education education = educationRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("education with id [%s] not found .".formatted(id)));
        boolean changed = false;
        if(updateRequest.getEducationLevel() != null && !updateRequest.getEducationLevel().equals(education.getEducationLevel())){
            education.setEducationLevel(updateRequest.getEducationLevel());
            changed = true;
        }
        if(updateRequest.getField() !=null && ! updateRequest.getField().equals(education.getField())){
            education.setField(updateRequest.getField());
            changed = true;
        }
        if(!changed){
            throw new RequestValidationException("no data changes found");
        }
        educationRepository.save(education);
        return education;
    }

    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }
}
