package com.web.springbootproject.controller.employee;

import com.web.springbootproject.entity.employee.Certificate;
import com.web.springbootproject.service.employee.CertificateService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/certificate")
public class CertificateController {
    @Autowired
    private final CertificateService certificateService;
    @GetMapping
    public List<Certificate> getCertificates(){
        return certificateService.getAllCertificate();
    }
    @GetMapping(path = "{id}")
    public Optional<Certificate> getCertificate(@PathVariable Long id){
        return certificateService.getCertificate(id);
    }
    @PostMapping
    public List<Certificate> addCertificate(@RequestParam Long profileId,
                                            @RequestBody Certificate certificate){
        return  certificateService.addCertificate(profileId,certificate);
    }
    @PutMapping(path = "{id}")
    public Certificate updateCertificate(@PathVariable Long id,
                                         @RequestBody Certificate requestCertificate){
        return certificateService.updateCertificate(id,requestCertificate);
    }
    @DeleteMapping(path = "{id}")
    public void deleteCertificate(@PathVariable Long id){
        certificateService.deleteCertificate(id);
    }
}
