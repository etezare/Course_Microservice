package com.compro.course.dto;

import java.util.Date;

public abstract class EmployeeResponse extends PersonResponse {
    private Date hiring_date;
    private String office;
    private String description;

    EmployeeResponse() {
        super();
    }

    public Date getHiring_date() {
        return hiring_date;
    }

    public void setHiring_date(Date hiring_date) {
        this.hiring_date = hiring_date;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
