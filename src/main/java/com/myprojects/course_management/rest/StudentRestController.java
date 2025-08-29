package com.myprojects.course_management.rest;

import com.myprojects.course_management.entity.Student;
import com.myprojects.course_management.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    StudentService studentService;

    public StudentRestController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> listAll(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.findByStudentId(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return student;
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student){
        Student tempStudent = studentService.findByStudentId(id);

        tempStudent.setFirstName(student.getFirstName());
        tempStudent.setLastName(student.getLastName());
        tempStudent.setEmail(student.getEmail());

        studentService.addStudent(tempStudent);
        return tempStudent;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }
}
