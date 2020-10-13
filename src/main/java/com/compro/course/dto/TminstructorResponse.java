package com.compro.course.dto;

import java.util.Collection;

public class TminstructorResponse extends EmployeeResponse {

    private long id;

    private Collection<StudentResponse> studentResponses;

    public TminstructorResponse() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Collection<StudentResponse> getStudentResponses() {
        return studentResponses;
    }

    public void setStudentResponses(Collection<StudentResponse> studentResponses) {
        this.studentResponses = studentResponses;
    }
}
