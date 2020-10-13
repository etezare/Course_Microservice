package com.compro.course.dto;

import java.util.Date;

public class StudentResponse extends PersonResponse {
    private long id;
    private String badge;
    private Date enrollment_date;
    private Date graduation_date;
    private float gpa;

    private CoachResponse coachResponse;
    private TminstructorResponse tminstructorResponse;

    public StudentResponse() {}

    public StudentResponse(String student_id, float gpa) {
        this.badge = student_id;
        this.gpa = gpa;

    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String student_id) {
        this.badge = student_id;
    }

    public Date getEnrollment_date() {
        return enrollment_date;
    }

    public void setEnrollment_date(Date enrollment_date) {
        this.enrollment_date = enrollment_date;
    }

    public Date getGraduation_date() {
        return graduation_date;
    }

    public void setGraduation_date(Date graduation_date) {
        this.graduation_date = graduation_date;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public CoachResponse getCoachResponse() {
        return coachResponse;
    }

    public void setCoachResponse(CoachResponse coachResponse) {
        this.coachResponse = coachResponse;
    }
}
