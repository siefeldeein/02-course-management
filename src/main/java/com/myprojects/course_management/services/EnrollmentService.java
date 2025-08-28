package com.myprojects.course_management.services;

import com.myprojects.course_management.entity.Enrollment;
import com.myprojects.course_management.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository){
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Enrollment> findAll(){
        return enrollmentRepository.findAll();
    }

    public Enrollment findById(Long id){
        Optional<Enrollment> enroll = enrollmentRepository.findById(id);
        return enroll.orElse(null);
    }

    public void addEnrollment(Enrollment enroll){
        enrollmentRepository.save(enroll);
    }

    public void deleteEnrollment(long id){
        enrollmentRepository.deleteById(id);
    }
}
