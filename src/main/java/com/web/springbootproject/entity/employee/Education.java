package com.web.springbootproject.entity.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "education")
public class Education {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String educationLevel;
    private String field;
    public Education(String educationLevel, String field) {
        this.educationLevel = educationLevel;
        this.field = field;
    }
}
