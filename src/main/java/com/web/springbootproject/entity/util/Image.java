package com.web.springbootproject.entity.util;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.web.springbootproject.entity.company.Job;
import com.web.springbootproject.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Image {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private Long fileDataId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_image_id_fk"
            )
    )
    @JsonBackReference
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "job_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "job_image_id_fk"
            )
    )
    private Job job;

}
