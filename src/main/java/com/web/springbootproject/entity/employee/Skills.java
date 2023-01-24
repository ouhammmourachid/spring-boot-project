package com.web.springbootproject.entity.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "skills")
public class Skills{
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String label;
    @Column(nullable = false)
    private String since;
    @ManyToOne
    @JoinColumn(
            name = "profile_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "profile_skills_fk"
            )
    )
    private Profile profile;
    public Skills(String label, String since) {
        this.label = label;
        this.since = since;
    }
}
