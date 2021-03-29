package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateOfCompletion;
    private Boolean complete_status;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateOfCreation;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateOfChange;

    @ManyToOne
    private Category category;
    @ManyToOne
    private Person person;
}
