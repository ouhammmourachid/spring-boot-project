package com.web.springbootproject.entity.employee;

import com.web.springbootproject.entity.company.Application;
import com.web.springbootproject.entity.company.Message;
import com.web.springbootproject.entity.company.Review;
import com.web.springbootproject.entity.user.User;
import com.web.springbootproject.entity.util.Document;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String headLine;
    private String phoneNumber;
    @Column(nullable = false)
    private String country;
    private String cityOrState;
    @Column(columnDefinition = "boolean default true")
    private boolean showPhoneNumber;
    private String jobTitle;
    private String company;
    @Column(columnDefinition = "boolean default false")
    private boolean readyToWork;
    @Column(nullable = false)
    private LocalDate dob;
    @Transient
    private Integer age;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "document_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "document_profile_id_fk"
            )
    )
    private Document file;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_profile_id_fk"
            )
    )
    private User user;
    @OneToMany(
            mappedBy = "profile",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Education> educations = new ArrayList<>();
    @OneToMany(
            mappedBy = "profile",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Certificate> certificates = new ArrayList<>();
    @OneToMany(
            mappedBy = "profile",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Skills> skills = new ArrayList<>();
    @OneToMany(
            mappedBy = "profile",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<License> licenses = new ArrayList<>();
    @OneToMany(
            mappedBy = "profile",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Language> languages = new ArrayList<>();
    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "profile"
    )
    private List<Application> applications = new ArrayList<>();
    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "profile"
    )
    private List<Review> reviews = new ArrayList<>();
    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "profile"
    )
    private List<Message> messages = new ArrayList<>();
    public Profile(String firstName,
                   String lastName,
                   String headLine,
                   String phoneNumber,
                   String country,
                   String cityOrState,
                   boolean showPhoneNumber,
                   String jobTitle,
                   String company,
                   boolean readyToWork,
                   LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.headLine = headLine;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.cityOrState = cityOrState;
        this.showPhoneNumber = showPhoneNumber;
        this.jobTitle = jobTitle;
        this.company = company;
        this.readyToWork = readyToWork;
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(dob,LocalDate.now()).getYears();
    }
}
