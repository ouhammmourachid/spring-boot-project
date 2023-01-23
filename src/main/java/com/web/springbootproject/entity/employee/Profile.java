package com.web.springbootproject.entity.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

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
