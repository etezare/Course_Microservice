package com.compro.course.dto;




public class GradeResponse {

    private Long Id;
    private double grade;

    private Long course;
    private String studentid;
//    @ManyToOne
//    private Student student;


    public GradeResponse(double grade) {
        this.grade = grade;
    }



    public GradeResponse() {
    }

    public GradeResponse(Long id, double grade) {
        Id = id;
        this.grade = grade;
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

    public Long getCourse() {
        return course;
    }

    public Long getId() {
        return Id;
    }

    public void setCourse(Long course) {
        this.course = course;
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
