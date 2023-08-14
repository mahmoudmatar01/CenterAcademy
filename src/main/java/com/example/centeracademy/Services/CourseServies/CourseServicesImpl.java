package com.example.centeracademy.Services.CourseServies;
import com.example.centeracademy.Dto.CourseDto;
import com.example.centeracademy.Entity.CourseEntity;
import com.example.centeracademy.Exceptions.NotFoundCourseException;
import com.example.centeracademy.Mapper.CourseMapperImpl;
import com.example.centeracademy.Mapper.ICourseMapper;
import com.example.centeracademy.Repository.ICoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServicesImpl implements ICourseServices{

    private final ICoursesRepository iCoursesRepository;
    private final ICourseMapper iCourseMapper=new CourseMapperImpl();

    @Autowired
    public CourseServicesImpl(ICoursesRepository iCoursesRepository) {
        this.iCoursesRepository = iCoursesRepository;
    }

    @Override
    public ResponseEntity<List<CourseDto>> findALlCourses() {
        List<CourseEntity> courseList=this.iCoursesRepository.findAll();
        List<CourseDto>courseDtoList=courseList.stream().map(iCourseMapper::courseToCourseDto).toList();
        return new ResponseEntity<>(courseDtoList, HttpStatus.OK);
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
        this.iCoursesRepository.save(course.get());

        CourseDto updatedCourse=this.iCourseMapper.courseToCourseDto(course.get());
        return new ResponseEntity<>(updatedCourse,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteCourse(Long courseId) {
        boolean isExist= this.iCoursesRepository.existsById(courseId);
        if(isExist){
            throw  new NotFoundCourseException("Course Not Found");
        }
        this.iCoursesRepository.deleteById(courseId);
        return new ResponseEntity<>("Course has been removed",HttpStatus.OK);
    }
}
