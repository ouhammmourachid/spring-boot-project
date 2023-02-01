package com.web.springbootproject.service.employee;

import com.web.springbootproject.entity.employee.Certificate;
import com.web.springbootproject.entity.employee.Profile;
import com.web.springbootproject.exception.RequestValidationException;
import com.web.springbootproject.exception.ResourceNotFoundException;
import com.web.springbootproject.repository.employee.CertificateRepository;
import com.web.springbootproject.repository.employee.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CertificateService {
    @Autowired
    private final CertificateRepository certificateRepository;
    @Autowired
    private final ProfileRepository profileRepository;
    public List<Certificate> getAllCertificate(){
        System.out.println("hello");
        return certificateRepository.findAll();
    }
    public Optional<Certificate> getCertificate(Long id){
        return certificateRepository.findById(id);
    }

    public List<Certificate> addCertificate(Long profileId, Certificate certificate) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(()-> new ResourceNotFoundException("profile with id [%s] not found .".formatted(profileId)));
        if(certificate.getLabel() != null && (certificate.getExpirationDate()==null && certificate.isDontExpire())) {
            profile.getCertificates().add(certificate);
            profileRepository.save(profile);
        }
        return profile.getCertificates();
    }

    public Certificate updateCertificate(Long id,Certificate updateRequest) {
        Certificate certificate = certificateRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("certificate with id [%s] not found .".formatted(id)));
        boolean changed = false;
        if(updateRequest.getLabel() != null && !updateRequest.getLabel().equals(certificate.getLabel())){
            certificate.setLabel(updateRequest.getLabel());
            changed = true;
        }
        if(updateRequest.getExpirationDate() != null &&
                !updateRequest.getExpirationDate().equals(certificate.getExpirationDate())){
            certificate.setExpirationDate(updateRequest.getExpirationDate());
            certificate.setDontExpire(false);
            changed = true;
        }
        if(updateRequest.isDontExpire()){
            certificate.setDontExpire(true);
            certificate.setExpirationDate(null);
            changed = true;
        }
        if(!changed){
            throw new RequestValidationException("no data changes found");
        }
        certificateRepository.save(certificate);
        return certificate;
    }

    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }
}
