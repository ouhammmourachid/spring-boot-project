package com.web.springbootproject.entity.util;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="fileData")
public class FileData {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    @Lob
    @Column(
            name = "fileData",
            length = 100_000_000
    )
    private byte[] fileData;
}