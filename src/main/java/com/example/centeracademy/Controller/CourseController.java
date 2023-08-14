package com.example.centeracademy.Controller;

import com.example.centeracademy.Dto.CourseDto;
import com.example.centeracademy.Services.CourseServies.CourseServicesImpl;
import com.example.centeracademy.Services.CourseServies.ICourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1/courses")
public class CourseController {
    private final ICourseServices iCourseServices;
    @Autowired
    public CourseController(CourseServicesImpl iCourseServices) {
        this.iCourseServices = iCourseServices;
    }


    @GetMapping()
    public ResponseEntity<Page<CourseDto>>getAllCourse(Pageable page){
        return  new ResponseEntity<>(iCourseServices.findALlCourses(page), HttpStatus.OK);
    }

    @GetMapping("/get_by_id")
    public ResponseEntity<CourseDto>getCourseById(@RequestParam Long courseId){
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
