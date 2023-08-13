package com.example.centeracademy.Controller;

import com.example.centeracademy.Dto.CourseDto;
import com.example.centeracademy.Services.CourseServies.CourseServicesImpl;
import com.example.centeracademy.Services.CourseServies.ICourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/courses")
public class CourseController {
    final ICourseServices iCourseServices;
    @Autowired
    public CourseController(CourseServicesImpl iCourseServices) {
        this.iCourseServices = iCourseServices;
    }


    @GetMapping("/")
    public ResponseEntity<List<CourseDto>>getAllCourse(){
        return  this.iCourseServices.findALlCourses();
    }

    @GetMapping(path = "/{courseId}")
    public ResponseEntity<CourseDto>getCourseById(@PathVariable Long id){
        return this.iCourseServices.findCourseById(id);
    }


    @PostMapping("/")
    public ResponseEntity<CourseDto>createCourse(@RequestBody CourseDto courseDto){
        return  this.createCourse(courseDto);
    }

    @PutMapping(path = "/{courseId}")
    public ResponseEntity<CourseDto>updateCourse(@PathVariable Long id ,@RequestBody CourseDto courseDto){
        return  this.updateCourse(id,courseDto);
    }

    @DeleteMapping(path = "/{courseId}")
    public ResponseEntity<String>removeCourse(@PathVariable Long id){
        return this.iCourseServices.deleteCourse(id);
    }
}
