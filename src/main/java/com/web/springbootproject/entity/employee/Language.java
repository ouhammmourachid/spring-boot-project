package com.web.springbootproject.entity.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String level;
    @ManyToOne
    @JoinColumn(
            name = "profile_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "profile_language_fk"
            )
    )
    private Profile profile;
    public Language(String name, String level) {
        this.name = name;
        this.level = level;
    }
}
