package com.web.springbootproject.entity.user;

import com.web.springbootproject.entity.company.Company;
import com.web.springbootproject.entity.employee.Profile;
import com.web.springbootproject.entity.util.File;
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
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @OneToOne(
            mappedBy = "user",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}

    )
    private Profile profile;
    @OneToOne(
            mappedBy = "user",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}

    )
    private Company company;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "file_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "file_id_fk"
            )
    )
    private File image;

    public User(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }
}
