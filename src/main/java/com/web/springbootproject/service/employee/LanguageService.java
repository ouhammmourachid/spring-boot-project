package com.web.springbootproject.service.employee;

import com.web.springbootproject.entity.employee.Language;
import com.web.springbootproject.entity.employee.Profile;
import com.web.springbootproject.exception.RequestValidationException;
import com.web.springbootproject.exception.ResourceNotFoundException;
import com.web.springbootproject.repository.employee.LanguageRepository;
import com.web.springbootproject.repository.employee.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LanguageService {
    @Autowired
    private final LanguageRepository languageRepository;
    @Autowired
    private final ProfileRepository profileRepository;
    public List<Language> getAllLanguages(){
        return languageRepository.findAll();
    }
    public Optional<Language> getLanguage(Long id){
        return languageRepository.findById(id);
    }
    public List<Language> addLanguage(Long profileId,Language language){
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(()-> new ResourceNotFoundException("profile with id [%s] not found .".formatted(profileId)));
        if(language.getName() != null && language.getLevel() != null){
            profile.getLanguages().add(language);
            profileRepository.save(profile);
        }
        return profile.getLanguages() ;
    }
    public Language updateLanguage(Long id,Language updateRequest){
        Language language = languageRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("language with id [%s] not found .".formatted(id)));
        boolean changed = false;
        if(updateRequest.getName() != null && !updateRequest.getName().equals(language.getName())){
            language.setName(updateRequest.getName());
            changed = true;
        }
        if(updateRequest.getLevel() != null && !updateRequest.getLevel().equals(language.getLevel())){
            language.setLevel(updateRequest.getLevel());
            changed = true;
        }
        if(!changed){
            throw new RequestValidationException("no data changes found");
        }
        languageRepository.save(language);
        return language;
    }

    public void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }
}
