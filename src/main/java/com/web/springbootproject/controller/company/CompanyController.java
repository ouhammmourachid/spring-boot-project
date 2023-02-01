package com.web.springbootproject.controller.company;

import com.web.springbootproject.entity.company.Company;
import com.web.springbootproject.service.company.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/company")
public class CompanyController {
    @Autowired
    private final CompanyService companyService;
    @GetMapping
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }
    @GetMapping(path = "{id}")
    public Optional<Company> getCompany(@PathVariable Long id){
        return companyService.getCompany(id);
    }
    @PostMapping
    public Company addCompany(@RequestParam Long userId,
                              @RequestBody Company company){
        return companyService.addCompany(userId,company);
    }
    @PutMapping
    public Company updateCompany(@RequestParam Long companyId,
                                 @RequestBody Company updateRequest){
        return companyService.updateCompany(companyId,updateRequest);
    }
}
