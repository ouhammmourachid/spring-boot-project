package com.web.springbootproject.entity.company;

import com.web.springbootproject.entity.company.embadded.ApplicationId;
import com.web.springbootproject.entity.employee.Profile;
import com.web.springbootproject.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "application")
@NoArgsConstructor
@Data
public class Application {

    @EmbeddedId
    private ApplicationId id;
    private String status;
    private LocalDate applyDate;
    @ManyToOne
    @MapsId("jobId")
    @JoinColumn(
            name = "job_id",
            foreignKey = @ForeignKey(
                    name = "application_job_id_fk"
            )
    )
    private Job job;
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(
                    name = "application_user_id_fk"
            )
    )
    private User user;
}
