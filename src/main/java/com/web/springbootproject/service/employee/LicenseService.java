package com.web.springbootproject.service.employee;

import com.web.springbootproject.entity.employee.License;
import com.web.springbootproject.entity.employee.Profile;
import com.web.springbootproject.entity.employee.Skills;
import com.web.springbootproject.exception.RequestValidationException;
import com.web.springbootproject.exception.ResourceNotFoundException;
import com.web.springbootproject.repository.employee.LicenseRepository;
import com.web.springbootproject.repository.employee.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class LicenseService {
    @Autowired
    private final LicenseRepository licenseRepository;
    @Autowired
    private final ProfileRepository profileRepository;
    public List<License> getAllLicense(){
        return licenseRepository.findAll();
    }
    public Optional<License> getLicense(Long id){
        return licenseRepository.findById(id);
    }
    public List<License> addLicense(Long profileId,License license){
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(()-> new ResourceNotFoundException("profile with id [%s] not found .".formatted(profileId)));
        if(license.getLabel() != null && (license.getExpirationDate()==null && license.isDontExpire())){
            profile.getLicenses().add(license);
            profileRepository.save(profile);
        }
        return profile.getLicenses() ;
    }
    public License updateLicense(Long id,License updateRequest){
        License license = licenseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("License with id [%s] not found .".formatted(id)));
        boolean changed = false;
        if(updateRequest.getLabel() != null && !updateRequest.getLabel().equals(license.getLabel())){
            license.setLabel(updateRequest.getLabel());
            changed = true;
        }
        if(updateRequest.getExpirationDate() != null &&
                !updateRequest.getExpirationDate().equals(license.getExpirationDate())){
            license.setExpirationDate(updateRequest.getExpirationDate());
            license.setDontExpire(false);
            changed = true;
        }
        if(updateRequest.isDontExpire()){
            license.setDontExpire(true);
            license.setExpirationDate(null);
            changed = true;
        }
        if(!changed){
            throw new RequestValidationException("no data changes found");
        }
        licenseRepository.save(license);
        return license;
    }

    public void deleteLicense(Long id) {
        licenseRepository.deleteById(id);
    }
}
