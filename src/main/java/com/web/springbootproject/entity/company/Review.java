package com.web.springbootproject.entity.company;

import com.web.springbootproject.entity.company.embadded.ReviewId;
import com.web.springbootproject.entity.employee.Profile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "review")
@NoArgsConstructor
@Getter
@Setter
public class Review {
    @EmbeddedId
    private ReviewId id;
    @Column(nullable = false)
    private Float stars;
    @Column(nullable = false)
    private String comment;
    private LocalDate createDate;

}
