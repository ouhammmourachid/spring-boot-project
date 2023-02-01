package com.web.springbootproject.service.company;

import com.web.springbootproject.entity.company.Company;
import com.web.springbootproject.entity.user.User;
import com.web.springbootproject.exception.RequestValidationException;
import com.web.springbootproject.exception.ResourceNotFoundException;
import com.web.springbootproject.repository.company.CompanyRepository;
import com.web.springbootproject.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyService {
    @Autowired
    private final CompanyRepository companyRepository;
    @Autowired
    private  final UserRepository userRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompany(Long id) {
        return companyRepository.findById(id);
    }

    public Company addCompany(Long userId,Company company) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("user with id [%s] not found .".formatted(userId)));
        user.setCompany(company);
        company.setUser(user);
        userRepository.save(user);
        return user.getCompany();
    }

    public Company updateCompany(Long companyId, Company updateRequest) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(()-> new ResourceNotFoundException("Company with id [%s] not found .".formatted(companyId)));
        boolean changed = false;
        if(updateRequest.getName() != null && !updateRequest.getName().equals(company.getName())){
            company.setName(updateRequest.getName());
            changed = true;
        }
        if(updateRequest.getLanguage() != null && !updateRequest.getLanguage().equals(company.getLanguage())){
            company.setLanguage(updateRequest.getLanguage());
            changed = true;
        }
        if(updateRequest.getCountry() != null && !updateRequest.getCountry().equals(company.getCountry())){
            company.setCountry(updateRequest.getCountry());
            changed = true;
        }
        if(updateRequest.getAddress() != null && !updateRequest.getAddress().equals(company.getAddress())){
            company.setAddress(updateRequest.getAddress());
            changed = true;
        }
        if(updateRequest.getTypeOfIndustry() != null && !updateRequest.getTypeOfIndustry().equals(company.getTypeOfIndustry())){
            company.setTypeOfIndustry(updateRequest.getTypeOfIndustry());
            changed = true;
        }
        if(updateRequest.getDescription() != null && !updateRequest.getDescription().equals(company.getDescription())){
            company.setDescription(updateRequest.getDescription());
            changed = true;
        }
        if(updateRequest.getPhoneNumber() != null && !updateRequest.getPhoneNumber().equals(company.getPhoneNumber())){
            company.setPhoneNumber(updateRequest.getPhoneNumber());
            changed = true;
        }
        if(!changed){
            throw new RequestValidationException("no data changes found");
        }
        return companyRepository.save(company);
    }
}
