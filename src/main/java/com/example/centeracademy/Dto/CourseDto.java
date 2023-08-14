package com.example.centeracademy.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
public class CourseDto {
    private String courseName;
    private String courseDescription;
    private double coursePrice;
    private String createdAt;
    public CourseDto(){}

    public CourseDto(String courseName, String courseDescription, double price, String createdAt) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.coursePrice = price;
        this.createdAt = createdAt;
    }
}
