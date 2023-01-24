package com.web.springbootproject.entity.util;

import com.web.springbootproject.entity.company.Job;
import com.web.springbootproject.entity.user.User;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Image extends File{
    @OneToOne(
            mappedBy = "image",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}

    )
    private User user;
    @OneToOne(
            mappedBy = "image",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}

    )
    private Job job;

}
