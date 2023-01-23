package com.web.springbootproject.entity.company;

import java.time.LocalDate;

public class Message {
    // TODO: add the annotation so that we can persist the object from the database .
    private Long id;
    private String message;
    private LocalDate createdDate;
}
