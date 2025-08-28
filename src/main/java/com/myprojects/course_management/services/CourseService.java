package com.myprojects.course_management.services;

import com.myprojects.course_management.entity.Course;
import com.myprojects.course_management.entity.Student;
import com.myprojects.course_management.repository.CourseRepository;
import com.myprojects.course_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    CourseRepository courseRepository;

    public CourseService (CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    public Course findByCourseId(int id){
        Optional<Course> course = courseRepository.findById(id);

        return course.orElse(null);
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void deleteCourse (int id){
        courseRepository.deleteById(id);
    }

}
