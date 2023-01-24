package com.web.springbootproject.entity.company;

import com.web.springbootproject.entity.company.embadded.MessageId;
import com.web.springbootproject.entity.employee.Profile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "message")
@NoArgsConstructor
@Getter
@Setter
public class Message {
    @EmbeddedId
    private MessageId id;
    @Column(nullable = false)
    private String message;
    private LocalDate createdDate;
    @ManyToOne
    @MapsId("companyId")
    @JoinColumn(
            name = "company_id",
            foreignKey = @ForeignKey(
                    name = "message_company_id_fk"
            )
    )
    private Company company;
    @ManyToOne
    @MapsId("profileId")
    @JoinColumn(
            name = "profile_id",
            foreignKey = @ForeignKey(
                    name = "message_profile_id_fk"
            )
    )
    private Profile profile;
}
