package com.compro.course.domain;

import com.compro.course.dto.StudentResponse;

import javax.persistence.*;

@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private double grade;
    @ManyToOne
    @JoinColumn
    private Course course;
    @Column(name = "student_id",nullable = true)
    private String studentid;
//    @ManyToOne
//    private Student student;


    public Grade(double grade) {
        this.grade = grade;
    }

    public Grade(Course course) {
        this.course = course;
    }

    public Grade() {
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    private void setId(Long id) {
        Id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "Id=" + Id +
                ", grade=" + grade +
                ", course=" + course +
                '}';
    }
}
