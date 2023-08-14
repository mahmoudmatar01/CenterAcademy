package com.example.centeracademy.Services.CourseServies;

import com.example.centeracademy.Dto.CourseDto;
import com.example.centeracademy.Entity.CourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICourseServices {
   Page<CourseDto> findALlCourses(Pageable page);
    ResponseEntity<CourseDto> findCourseById(Long courseId);
    ResponseEntity<CourseDto> addNewCourse(CourseDto newCourse);
    ResponseEntity<CourseDto> updateCourse(Long id,CourseDto newCourse);
    ResponseEntity<String> deleteCourse(Long courseId);
}
