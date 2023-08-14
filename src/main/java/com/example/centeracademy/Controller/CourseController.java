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
    private ICourseServices iCourseServices;
    @Autowired
    public CourseController(CourseServicesImpl iCourseServices) {
        this.iCourseServices = iCourseServices;
    }


    @GetMapping("/")
    public ResponseEntity<List<CourseDto>>getAllCourse(){
        return  this.iCourseServices.findALlCourses();
    }

    @GetMapping(path = "/{courseId}")
    public ResponseEntity<CourseDto>getCourseById(@PathVariable Long courseId){
        return this.iCourseServices.findCourseById(courseId);
    }


    @PostMapping("/")
    public ResponseEntity<CourseDto>createCourse(@RequestBody CourseDto courseDto){
        return  iCourseServices.addNewCourse(courseDto);
    }

    @PutMapping(path = "/{courseId}")
    public ResponseEntity<CourseDto>updateCourse(@PathVariable Long courseId ,@RequestBody CourseDto courseDto){
        return  iCourseServices.updateCourse(courseId,courseDto);
    }

    @DeleteMapping(path = "/{courseId}")
    public ResponseEntity<String>removeCourse(@PathVariable Long courseId){
        return iCourseServices.deleteCourse(courseId);
    }
}
