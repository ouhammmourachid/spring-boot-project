package com.web.springbootproject.entity.company;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String language;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String typeOfIndustry;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String phoneNumber;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "company_job_fk",referencedColumnName = "id")
    @JsonManagedReference
    private List<Job> jobs;
    public Company(String name,
                   String language,
                   String country,
                   String address,
                   String typeOfIndustry,
                   String description,
                   String phoneNumber) {
        this.name = name;
        this.language = language;
        this.country = country;
        this.address = address;
        this.typeOfIndustry = typeOfIndustry;
        this.description = description;
        this.phoneNumber = phoneNumber;
    }
}
