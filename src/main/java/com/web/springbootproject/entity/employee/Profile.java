package com.web.springbootproject.entity.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.web.springbootproject.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
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
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_certificate_fk",referencedColumnName = "id")
    private List<Certificate> certificates;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_education_fk",referencedColumnName = "id")
    private List<Education> educations ;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_language_fk",referencedColumnName = "id")
    private List<Language> languages;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_license_fk",referencedColumnName = "id")
    private List<License> licenses;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_skills_fk",referencedColumnName = "id")
    private List<Skills> skills;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_profile_id_fk"
            )
    )
    @JsonBackReference
    private User user;

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
