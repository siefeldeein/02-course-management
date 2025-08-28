package com.myprojects.course_management.services;

import com.myprojects.course_management.entity.Student;
import com.myprojects.course_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;
    public StudentService (StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
       return studentRepository.findAll();
    }

    public Student findByStudentId(int id){
        Optional<Student> stud = studentRepository.findById(id);

        return stud.orElse(null);
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent (int id){
        studentRepository.deleteById(id);
    }


}
