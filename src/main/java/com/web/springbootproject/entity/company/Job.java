package com.web.springbootproject.entity.company;

import com.web.springbootproject.entity.util.Document;
import com.web.springbootproject.entity.util.Image;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @Column(nullable = false)
    private LocalDate createdDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "image_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "image_job_id_fk"
            )
    )
    private Image image;
    @OneToOne
    @JoinColumn(
            name = "document_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "document_job_id_fk"
            )
    )
    private Document file;
    @ManyToOne
    @JoinColumn(
            name = "company_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "company_job_fk"
            )
    )
    private Company company;
    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "job"
    )
    private List<Application> applications = new ArrayList<>();
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
