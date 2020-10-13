package com.compro.course.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Attendance {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
     private String attendance_type;
     private boolean isAbsent;
     @ManyToOne
     @JoinColumn
     private Course course;
     @Temporal(TemporalType.DATE)
     private Date date;
     @Column(name="student_id")
     private String student_id;


    public Attendance(String attendance_type, boolean isAbsent, Date date) {
        this.attendance_type = attendance_type;
        this.isAbsent = isAbsent;
        this.date = date;

    }

    public Attendance() {

    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public long getId() {
        return id;
    }

    public String getAttendance_type() {
        return attendance_type;
    }

    public void setAttendance_type(String attendance_type) {
        this.attendance_type = attendance_type;
    }

    public boolean isAbsent() {
        return isAbsent;
    }

    public void setAbsent(boolean absent) {
        isAbsent = absent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(long id) {
        this.id = id;
    }
}
