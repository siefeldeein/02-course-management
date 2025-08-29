package com.myprojects.course_management.rest;

import com.myprojects.course_management.entity.Course;
import com.myprojects.course_management.entity.Course;
import com.myprojects.course_management.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseRestController {

    CourseService courseService;

    @Autowired
    public CourseRestController(CourseService courseService){
        this.courseService=courseService;
    }

    @GetMapping
    public List<Course> listAll(){
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id){
        return courseService.findByCourseId(id);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course){
        courseService.addCourse(course);
        return course;
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course course){
        Course tempCourse = courseService.findByCourseId(id);

        tempCourse.setTitle(course.getTitle());
        tempCourse.setDescription(course.getDescription());
        tempCourse.setCredits(course.getCredits());

        courseService.addCourse(tempCourse);
        return tempCourse;
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }
}
