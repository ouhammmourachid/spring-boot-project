package com.web.springbootproject.entity.util;

import com.web.springbootproject.entity.employee.Profile;
import com.web.springbootproject.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String type;
    @OneToOne(
            mappedBy = "file",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}

    )
    private Profile profile;
    @OneToOne(
            mappedBy = "image",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}

    )
    private User user;
    public File(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
