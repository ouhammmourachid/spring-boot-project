package com.web.springbootproject.service.company;

import com.web.springbootproject.entity.company.Company;
import com.web.springbootproject.entity.company.Review;
import com.web.springbootproject.entity.company.embadded.ReviewId;
import com.web.springbootproject.entity.user.User;
import com.web.springbootproject.exception.ResourceNotFoundException;
import com.web.springbootproject.repository.company.CompanyRepository;
import com.web.springbootproject.repository.company.ReviewRepository;
import com.web.springbootproject.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {
    @Autowired
    private final ReviewRepository reviewRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final CompanyRepository companyRepository;

    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }

    public Review addReview(Long userId, Long companyId,Review review) {
        review.setId(new ReviewId(userId,companyId));
        Company company = companyRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("company with id [%s] not found.".formatted(companyId)));
        User user = userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("user with id [%s] not found.".formatted(userId)));
        review.setUser(user);
        review.setCreateDate(LocalDate.now());
        review.setCompany(company);
        return reviewRepository.save(review);
    }
}
