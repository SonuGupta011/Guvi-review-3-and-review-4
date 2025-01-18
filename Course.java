package com.lms.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Course name cannot be empty")
    @Size(min = 3, max = 100, message = "Course name must be between 3 and 100 characters")
    private String name;

    @NotEmpty(message = "Course description cannot be empty")
    @Size(min = 10, max = 500, message = "Course description must be between 10 and 500 characters")
    private String description;

    // Getters and Setters
}
