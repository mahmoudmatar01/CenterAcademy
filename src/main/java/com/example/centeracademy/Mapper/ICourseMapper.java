package com.example.centeracademy.Mapper;

import com.example.centeracademy.Dto.CourseDto;
import com.example.centeracademy.Entity.CourseEntity;

public interface ICourseMapper {
   CourseEntity addCourseDtoToCourse(CourseDto courseDto);
   CourseDto courseToCourseDto(CourseEntity course);
}
