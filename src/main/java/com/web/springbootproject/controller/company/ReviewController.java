package com.web.springbootproject.controller.company;

import com.web.springbootproject.entity.company.Review;
import com.web.springbootproject.service.company.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/review")
@AllArgsConstructor
public class ReviewController {
    @Autowired
    private final ReviewService reviewService;
    @GetMapping
    public List<Review> getAllReview(){
        return reviewService.getAllReview();
    }
    @PostMapping
    public Review addReview(@RequestParam Long userId,
                            @RequestParam Long companyId,
                            @RequestBody Review review){
        return reviewService.addReview(userId,companyId,review);
    }
}
