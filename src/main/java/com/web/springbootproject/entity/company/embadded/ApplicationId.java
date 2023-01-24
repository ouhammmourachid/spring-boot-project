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
public class ApplicationId implements Serializable {
    @Column(name = "profile_id")
    private Long profileId;
    @Column(name = "job_id")
    private Long jobId;
}
