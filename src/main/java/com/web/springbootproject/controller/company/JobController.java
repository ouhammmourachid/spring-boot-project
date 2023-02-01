package com.web.springbootproject.controller.company;

import com.web.springbootproject.entity.company.Job;
import com.web.springbootproject.service.company.JobService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/job")
public class JobController {
    @Autowired
    private final JobService jobService;
    @GetMapping
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }
    @GetMapping(path = "{id}")
    public Optional<Job> getJob(@PathVariable Long id){
        return jobService.getJob(id);
    }
    @PostMapping
    public  List<Job> addJob(@RequestParam Long companyId,
                       @RequestBody Job job){
        return jobService.addJob(companyId,job);
    }
    @PutMapping
    public Job updateJob(@RequestParam Long jobId,
                         @RequestBody Job updateRequest){
        return jobService.updateJob(jobId,updateRequest);
    }
}
