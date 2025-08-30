package com.myprojects.course_management.mvc;

import com.myprojects.course_management.entity.Student;
import com.myprojects.course_management.services.EnrollmentService;
import com.myprojects.course_management.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    StudentService studentService;
    EnrollmentService enrollmentService;

    public StudentController (StudentService studentService, EnrollmentService enrollmentService){
        this.studentService=studentService;
        this.enrollmentService=enrollmentService;
    }

    @GetMapping("/list")
    public String listStudents (Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("students",students);
        return "list-students";
    }
}
