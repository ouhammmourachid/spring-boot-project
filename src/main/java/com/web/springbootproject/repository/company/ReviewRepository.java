package com.web.springbootproject.repository.company;

import com.web.springbootproject.entity.company.Review;
import com.web.springbootproject.entity.company.embadded.ReviewId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, ReviewId> {
}
