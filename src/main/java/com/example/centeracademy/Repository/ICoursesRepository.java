package com.example.centeracademy.Repository;
import com.example.centeracademy.Dto.CourseDto;
import com.example.centeracademy.Entity.CourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoursesRepository extends JpaRepository<CourseEntity,Long> {

    Page<CourseEntity> findAll(Pageable page);
}
