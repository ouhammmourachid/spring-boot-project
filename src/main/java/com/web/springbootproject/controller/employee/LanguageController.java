package com.web.springbootproject.controller.employee;

import com.web.springbootproject.entity.employee.Language;
import com.web.springbootproject.service.employee.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/language")
public class LanguageController {
    @Autowired
    private final LanguageService languageService;
    @GetMapping
    public List<Language> getAllLanguage(){
        return languageService.getAllLanguages();
    }
    @GetMapping(path = "{id}")
    public Optional<Language> getLanguage(@PathVariable Long id){
        return languageService.getLanguage(id);
    }
    @PostMapping
    public List<Language> addLanguage(@RequestParam Long profileId,
                                          @RequestBody Language language ){
        return  languageService.addLanguage(profileId,language);
    }
    @PutMapping(path = "{id}")
    public Language updateLanguage(@PathVariable Long id,
                                       @RequestBody Language updateRequest){
        return languageService.updateLanguage(id,updateRequest);
    }
    @DeleteMapping(path = "{id}")
    public void deleteLanguage(@PathVariable Long id){
        languageService.deleteLanguage(id);
    }
}
