package com.example.centeracademy.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @Column(name = "courseId")
//    @JsonProperty("courseId")
    private Long courseId;

    @Column(name = "courseName",nullable = false)
    private String courseName;

    @Column(name = "coursePrice")
    private double coursePrice;

    @Column(name = "courseDescription" )
    private String courseDescription;

    @Column(name = "createdAt",nullable = false,updatable = false)
    private String createdAt;

}
