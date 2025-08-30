package com.myprojects.course_management.rest;

import com.myprojects.course_management.dto.EnrollmentRequest;
import com.myprojects.course_management.entity.Course;
import com.myprojects.course_management.entity.Enrollment;
import com.myprojects.course_management.entity.Student;
import com.myprojects.course_management.services.CourseService;
import com.myprojects.course_management.services.EnrollmentService;
import com.myprojects.course_management.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentRestController {

    EnrollmentService enrollmentService;
    StudentService studentService;
    CourseService courseService;

    public EnrollmentRestController(EnrollmentService enrollmentService,
                                    StudentService studentService, CourseService courseService){
        this.enrollmentService=enrollmentService;
        this.courseService=courseService;
        this.studentService=studentService;

    }

    @GetMapping
    public List<Enrollment> listAll(){
        return enrollmentService.findAll();
    }

    @GetMapping("/{id}")
    public Enrollment getEnrollmentById(@PathVariable long id){
        return enrollmentService.findById(id);
    }

    @PostMapping
    public Enrollment addEnrollment(@RequestBody Enrollment enrollment ){

        System.out.println(enrollment.getStudent());

        Student tempStudent = studentService.findByStudentId(enrollment.getStudent().getId());
        Course tempCourse = courseService.findByCourseId(enrollment.getCourse().getId());

        enrollment.setNotes(tempStudent.getFirstName() + " enrolled in " + tempCourse.getTitle() );

        enrollmentService.addEnrollment(enrollment);

        return enrollment;

    }

//    @PostMapping
//    public Enrollment addEnrollment(@RequestBody EnrollmentRequest request ){
//        System.out.println(request.getEnrollDate());
//        Course tempCourse = courseService.findByCourseId(request.getStudentId());
//        Student tempStudent = studentService.findByStudentId(request.getStudentId());
//
//        Enrollment enroll = new Enrollment();
//        enroll.setNotes(tempStudent.getFirstName() + " enrolled in " + tempCourse.getTitle());
//        enroll.setEnrollmentDate(request.getEnrollDate());
//
//        tempStudent.addEnrollment(enroll);
//        tempCourse.addEnrollment(enroll);
//
//        enrollmentService.addEnrollment(enroll);
//        return enroll;
//
//    }
}
