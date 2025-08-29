package com.myprojects.course_management.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "enrollment", uniqueConstraints =
        {@UniqueConstraint(name = "unique_student_course", columnNames ={"student_id", "course_id"} )})
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;

    @Column(name = "notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnoreProperties("enrollments")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonIgnoreProperties("enrollments")
    private Course course;

    public Enrollment() {
    }

    public Enrollment(Student student, Course course, LocalDate enrollmentDate, String notes) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.notes = notes;
    }

    // Getters & Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    // helper
//    public int getCourseId(){return course.getId();}
//    public void setCourseId(int id){ course.setId(id);}
//
//    public void setStudentId(int id){ student.setId(id);}
//    public int getStudentId(){return student.getId();}


    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(LocalDate enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", enrollmentDate=" + enrollmentDate +
                ", notes='" + notes +
                ", student=" + student +
                ", course=" + course + '\'' +
                '}';
    }

}
