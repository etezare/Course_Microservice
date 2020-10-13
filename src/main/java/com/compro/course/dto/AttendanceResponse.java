package com.compro.course.dto;



import java.util.Date;

public class AttendanceResponse {

     private long id;
     private String attendance_type;
     private boolean isAbsent;
     private Long course;
     private Date date;
     private String student_id;


    public AttendanceResponse(String attendance_type, boolean isAbsent, Date date) {
        this.attendance_type = attendance_type;
        this.isAbsent = isAbsent;
        this.date = date;

    }

    public AttendanceResponse(long id, String attendance_type, boolean isAbsent, Date date) {
        this.id = id;
        this.attendance_type = attendance_type;
        this.isAbsent = isAbsent;
        this.date = date;
    }

    public AttendanceResponse() {

    }

    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    public String getBadge() {
        return student_id;
    }

    public void setBadge(String student_id) {
        this.student_id = student_id;
    }

    public Long getId() {
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


}
