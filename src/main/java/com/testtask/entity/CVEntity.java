package com.testtask.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CVEntity {
    @Id
    private UUID id;
    private String name;
    private LocalDateTime date;
    @Lob
    @Column(name = "CONTENT", length = 10245)
    private String content;
}
