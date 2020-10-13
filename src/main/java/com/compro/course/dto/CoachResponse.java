package com.compro.course.dto;

import java.util.ArrayList;
import java.util.Collection;

public class CoachResponse extends EmployeeResponse {
    private long id;

    private Collection<StudentResponse> studentResponses = new ArrayList<>();

    public CoachResponse() {}

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
