package com.web.springbootproject.entity.company;

import java.time.LocalDate;

public class Review {
    // TODO: add the annotation so that the object will be persist from the database .
    private Long id;
    private Float stars;
    private String comment;
    private LocalDate createDate;

}
