package com.web.springbootproject.entity.company.embadded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ReviewId implements Serializable {
    @Column(name = "profile_id")
    private Long profileId;
    @Column(name = "company_id")
    private Long companyId;
}
