package com.myprojects.course_management.repository;

import com.myprojects.course_management.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}