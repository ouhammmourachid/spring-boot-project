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

}
