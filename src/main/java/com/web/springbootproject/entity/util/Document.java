package com.web.springbootproject.entity.util;

import com.web.springbootproject.entity.company.Job;
import com.web.springbootproject.entity.employee.Profile;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Document extends File{
    @OneToOne(
            mappedBy = "file",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}

    )
    private Profile profile;
    @OneToOne(
            mappedBy = "file",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}

    )
    private Job job;

}
