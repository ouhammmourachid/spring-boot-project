package com.web.springbootproject.entity.company;

import com.web.springbootproject.entity.company.embadded.ReviewId;
import com.web.springbootproject.entity.user.User;
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
    @ManyToOne
    @MapsId("companyId")
    @JoinColumn(
            name = "company_id",
            foreignKey = @ForeignKey(
                    name = "review_company_id_fk"
            )
    )
    private Company company;
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(
                    name = "review_user_id_fk"
            )
    )
    private User user;
}
