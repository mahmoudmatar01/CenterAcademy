package com.example.centeracademy.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "CoursesTable")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Course Id")
    private Long courseId;

    @Column(name = "Course Name",nullable = false)
    private String courseName;

    @Column(name = "Course Price")
    private double coursePrice;

    @Column(name = "Course Description" )
    private String courseDescription;

    @Column(name = "Created Date",nullable = false,updatable = false)
    private String createdAt;

}
