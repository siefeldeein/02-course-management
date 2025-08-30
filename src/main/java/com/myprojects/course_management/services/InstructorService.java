package com.myprojects.course_management.services;

import com.myprojects.course_management.entity.Instructor;
import com.myprojects.course_management.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    InstructorRepository instructorRepository;
    @Autowired
    public InstructorService(InstructorRepository instructorRepository){
        this.instructorRepository=instructorRepository;
    }

    public void addInstructor(Instructor instructor){
        instructorRepository.save(instructor);
    }

    public List<Instructor> ListAll(){
        return instructorRepository.findAll();
    }

    public Instructor findById(int id){
        return instructorRepository.findById(id).orElse(null);
    }

    public void deleteById(int id){
        instructorRepository.deleteById(id);
    }
}
