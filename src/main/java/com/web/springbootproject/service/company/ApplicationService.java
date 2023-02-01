package com.web.springbootproject.service.company;

import com.web.springbootproject.entity.company.Application;
import com.web.springbootproject.entity.company.Job;
import com.web.springbootproject.entity.company.embadded.ApplicationId;
import com.web.springbootproject.entity.user.User;
import com.web.springbootproject.exception.ResourceNotFoundException;
import com.web.springbootproject.repository.company.ApplicationRepository;
import com.web.springbootproject.repository.company.JobRepository;
import com.web.springbootproject.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ApplicationService {
    @Autowired
    private final ApplicationRepository applicationRepository;
    @Autowired
    private final JobRepository jobRepository;
    @Autowired
    private final UserRepository userRepository;

    public List<Application> getAllApplication() {
        return applicationRepository.findAll();
    }

    public Application addApplication(Long userId, Long jobId) {
        Application application = new Application();
        application.setId(new ApplicationId(userId,jobId));
        Job job = jobRepository.findById(jobId)
                .orElseThrow(()->new ResourceNotFoundException("job with id [%s] not found.".formatted(jobId)));
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("user with id [%s] not found.".formatted(userId)));
        application.setJob(job);
        application.setUser(user);
        return applicationRepository.save(application);
    }
}
