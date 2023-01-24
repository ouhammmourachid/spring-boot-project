package com.web.springbootproject.entity.company;

import com.web.springbootproject.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_company_id_fk"
            )
    )
    private User user;

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
