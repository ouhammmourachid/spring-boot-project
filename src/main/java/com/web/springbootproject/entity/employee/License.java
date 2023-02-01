package com.web.springbootproject.entity.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "license")
public class License {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String label;
    private LocalDate expirationDate;
    @Column(nullable = false)
    private boolean dontExpire;
    public License(String label,
                   LocalDate expirationDate,
                   boolean dontExpire) {
        this.label = label;
        this.expirationDate = expirationDate;
        this.dontExpire = dontExpire;
    }
}
