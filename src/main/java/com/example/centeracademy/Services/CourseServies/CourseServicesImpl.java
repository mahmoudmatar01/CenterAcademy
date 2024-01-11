package com.example.centeracademy.Services.CourseServies;
import com.example.centeracademy.Dto.CourseDto;
import com.example.centeracademy.Entity.CourseEntity;
import com.example.centeracademy.Exceptions.NotFoundCourseException;
import com.example.centeracademy.Mapper.CourseMapperImpl;
import com.example.centeracademy.Mapper.ICourseMapper;
import com.example.centeracademy.Repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServicesImpl implements ICourseServices{

    private final CoursesRepository iCoursesRepository;
    private final ICourseMapper iCourseMapper=new CourseMapperImpl();

    @Autowired
    public CourseServicesImpl(CoursesRepository iCoursesRepository) {
        this.iCoursesRepository = iCoursesRepository;
    }

    @Override
    public Page<CourseDto> findALlCourses(Pageable page) {
        Page<CourseEntity> courseList=iCoursesRepository.findAll(page);
//        List<CourseDto>courseDtoList=courseList.stream().map(iCourseMapper::courseToCourseDto).toList();
        return courseList.map(iCourseMapper::courseToCourseDto);
    }

    @Override
    public ResponseEntity<CourseDto> findCourseById(Long courseId) {
      Optional<CourseEntity> course= this.iCoursesRepository.findById(courseId);
      if(course.isEmpty()){
          throw  new NotFoundCourseException("Course Not Found");
      }
      CourseDto courseDto=iCourseMapper.courseToCourseDto(course.get());
        return new ResponseEntity<>(courseDto,HttpStatus.OK);
    }


    @Override
    public ResponseEntity<CourseDto> addNewCourse(CourseDto newCourse) {
        CourseEntity course=iCourseMapper.addCourseDtoToCourse(newCourse);
        CourseEntity createdCourse= this.iCoursesRepository.save(course);
        CourseDto savedCourse=this.iCourseMapper.courseToCourseDto(createdCourse);
        return new ResponseEntity<>(savedCourse,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CourseDto> updateCourse(Long id, CourseDto newCourse) {
        Optional<CourseEntity>course= this.iCoursesRepository.findById(id);
        if(course.isEmpty()){
            throw  new NotFoundCourseException("Course Not Found");
        }
        course.get().setCourseName(newCourse.getCourseName());
        course.get().setCoursePrice(newCourse.getCoursePrice());
        course.get().setCourseDescription(newCourse.getCourseDescription());
        course.get().setCreatedAt(newCourse.getCreatedAt());
        iCoursesRepository.save(course.get());

        CourseDto updatedCourse=this.iCourseMapper.courseToCourseDto(course.get());
        return new ResponseEntity<>(updatedCourse,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteCourse(Long courseId) {
        boolean isExist= this.iCoursesRepository.existsById(courseId);
        if(!isExist){
            throw  new NotFoundCourseException("Course Not Found");
        }
        this.iCoursesRepository.deleteById(courseId);
        return new ResponseEntity<>("Course has been removed",HttpStatus.OK);
    }
}
