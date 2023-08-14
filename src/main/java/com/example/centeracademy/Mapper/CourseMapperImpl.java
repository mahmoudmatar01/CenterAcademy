package com.example.centeracademy.Mapper;

import com.example.centeracademy.Dto.CourseDto;
import com.example.centeracademy.Entity.CourseEntity;
import org.springframework.stereotype.Component;

public class CourseMapperImpl implements  ICourseMapper{
    @Override
    public CourseEntity addCourseDtoToCourse(CourseDto courseDto) {
        CourseEntity course=new CourseEntity();
        course.setCourseName(courseDto.getCourseName());
        course.setCourseDescription(courseDto.getCourseDescription());
        course.setCoursePrice(courseDto.getCoursePrice());
        course.setCreatedAt(courseDto.getCreatedAt());
        return course;
    }

    @Override
    public CourseDto courseToCourseDto(CourseEntity course) {
        CourseDto courseDto=new CourseDto();
        courseDto.setCourseDescription(course.getCourseDescription());
        courseDto.setCoursePrice(course.getCoursePrice());
        courseDto.setCreatedAt(course.getCreatedAt());
        courseDto.setCourseName(course.getCourseName());

        return courseDto;
    }
}
