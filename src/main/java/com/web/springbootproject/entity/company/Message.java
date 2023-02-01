package com.web.springbootproject.entity.company;

import com.web.springbootproject.entity.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "message")
@NoArgsConstructor
@Data
public class Message {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String message;
    private LocalDate createdDate;
    @ManyToOne
    @JoinColumn(name = "send_id")
    private User sendByUser;
    @ManyToOne
    @JoinColumn(name = "received_id")
    private User receivedByUser;

}
