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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateOfCreation;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateOfChange;

    @OneToMany(targetEntity = Task.class)
    private List task;
}
