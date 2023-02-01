package com.web.springbootproject.controller.employee;

import com.web.springbootproject.entity.employee.Education;
import com.web.springbootproject.entity.employee.License;
import com.web.springbootproject.service.employee.LicenseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/license")
public class LicenseController {
    @Autowired
    private final LicenseService licenseService;
    @GetMapping
    public List<License> getAllLicense(){
        return licenseService.getAllLicense();
    }
    @GetMapping(path = "{id}")
    public Optional<License> getLicense(@PathVariable Long id){
        return licenseService.getLicense(id);
    }
    @PostMapping
    public List<License> addLicense(@RequestParam Long profileId,
                                          @RequestBody License license){
        return  licenseService.addLicense(profileId, license);
    }
    @PutMapping(path = "{id}")
    public License updateLicense(@PathVariable Long id,
                                       @RequestBody License updateRequest){
        return licenseService.updateLicense(id,updateRequest);
    }
    @DeleteMapping(path = "{id}")
    public void deleteLicense(@PathVariable Long id){
        licenseService.deleteLicense(id);
    }
}
