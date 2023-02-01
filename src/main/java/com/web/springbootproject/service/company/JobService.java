package com.web.springbootproject.service.company;

import com.web.springbootproject.entity.company.Company;
import com.web.springbootproject.entity.company.Job;
import com.web.springbootproject.exception.RequestValidationException;
import com.web.springbootproject.exception.ResourceNotFoundException;
import com.web.springbootproject.repository.company.CompanyRepository;
import com.web.springbootproject.repository.company.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JobService {
    @Autowired
    private final JobRepository jobRepository;
    @Autowired
    private final CompanyRepository companyRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Optional<Job> getJob(Long id) {
        return jobRepository.findById(id);
    }

    public List<Job> addJob(Long companyId, Job job) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(()-> new ResourceNotFoundException("Company with id [%s] not found .".formatted(companyId)));
        company.getJobs().add(job);
        return companyRepository.save(company).getJobs();
    }

    public Job updateJob(Long jobId, Job updateRequest) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(()-> new ResourceNotFoundException("Job with id [%s] not found .".formatted(jobId)));
        boolean changed = false;
        if(updateRequest.getTitle()!= null && !updateRequest.getTitle().equals(job.getTitle())){
            job.setTitle(updateRequest.getTitle());
            changed = true;
        }
        if(updateRequest.getRegion()!= null && !updateRequest.getRegion().equals(job.getRegion())){
            job.setRegion(updateRequest.getRegion());
            changed = true;
        }
        if(updateRequest.getNumberWanted()!= null && updateRequest.getNumberWanted()!= job.getNumberWanted()){
            job.setNumberWanted(updateRequest.getNumberWanted());
            changed = true;
        }
        if(updateRequest.getPay()!= null && updateRequest.getPay() != job.getPay() ){
            job.setPay(updateRequest.getPay());
            changed = true;
        }
        if(updateRequest.getCreatedDate()!= null && !updateRequest.getCreatedDate().equals(job.getCreatedDate())){
            job.setCreatedDate(updateRequest.getCreatedDate());
            changed = true;
        }
        if(!changed){
            throw new RequestValidationException("no data changes found");
        }
        return jobRepository.save(job);
    }
}
