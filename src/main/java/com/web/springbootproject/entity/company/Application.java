package com.web.springbootproject.entity.company;

import com.web.springbootproject.entity.company.embadded.ApplicationId;
import com.web.springbootproject.entity.employee.Profile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "application")
@NoArgsConstructor
@Getter
@Setter
public class Application {

    @EmbeddedId
    private ApplicationId id;
    private String status;
    private LocalDate applyDate;

}
