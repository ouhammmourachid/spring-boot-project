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
@Table(name = "certificate")
public class Certificate {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String label;
    private LocalDate expirationDate;
    @Column(nullable = false)
    private boolean dontExpire;
    @ManyToOne
    @JoinColumn(
            name = "profile_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "profile_certificate_fk"
            )
    )
    private Profile profile;
    public Certificate(String label,
                       LocalDate expirationDate,
                       boolean dontExpire) {
        this.label = label;
        this.expirationDate = expirationDate;
        this.dontExpire = dontExpire;
    }
}
