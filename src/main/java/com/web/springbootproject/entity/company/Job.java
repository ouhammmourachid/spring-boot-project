package com.web.springbootproject.entity.company;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)

    private String title;
    @Column(nullable = false)
    private String region;
    @Column(nullable = false)
    private Float pay;
    @Column(nullable = false)
    private Integer numberWanted;
    // TODO : to hard code the default value of the created Date .
    @Column(nullable = false)
    private LocalDate createdDate;

    public Job(String title,
               String region,
               float pay,
               Integer numberWanted,
               LocalDate createdDate) {
        this.title = title;
        this.region = region;
        this.pay = pay;
        this.numberWanted = numberWanted;
        this.createdDate = createdDate;
    }
}
