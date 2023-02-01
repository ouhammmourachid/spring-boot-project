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
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "job_id")
    private Long jobId;
}
