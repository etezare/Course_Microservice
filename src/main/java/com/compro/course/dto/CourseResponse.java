package com.compro.course.dto;

import com.compro.course.domain.Attendance;
import com.compro.course.domain.Grade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


public class CourseResponse {

    private Long id;
    private String courseId;
    private String title;
    private String building;
    private int room;

    private Date start_date;

    private Date end_date;

    private Collection<GradeResponse> grades;

    private Collection<AttendanceResponse>attendances=new ArrayList<>();

    private String faculty_id;

    private String TA;

    private Collection<String> _courseId_student_id = new ArrayList<>();
    public CourseResponse() {
    }

    public CourseResponse(Long id, String courseId, String title, String building, int room, Date start_date, Date end_date) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.building = building;
        this.room = room;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public CourseResponse(String courseId, String title, String building, int room, Date start_date, Date end_date) {
        this.title = title;
        this.courseId=courseId;
        this.building = building;
        this.room = room;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public CourseResponse(String TA) {
        this.TA = TA;
    }

    public void add_courseId_student_id(String _courseId_student_id) {
         this._courseId_student_id.add(_courseId_student_id);
    }

    public void remove_courseId_student_id(String _courseId_student_id) {
        this._courseId_student_id.remove(_courseId_student_id);
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void RemoveAttendance(AttendanceResponse attendance) {
        if(!attendances.isEmpty()) {
            attendances.remove(attendance);
        }
    }

    public void addAttendance(AttendanceResponse attendance) {
        attendances.add(attendance);
    }
    public void RemoveGrade(GradeResponse grade) {
        if(!grades.isEmpty()) {
            grades.remove(grade);
        }
    }

    public String getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(String faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getTA() {
        return TA;
    }

    public void setTA(String TA) {
        this.TA = TA;
    }

    public void addGrade(GradeResponse grade) {
        grades.add(grade);
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", building='" + building + '\'' +
                ", room=" + room +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", grades=" + grades +
                ", attendances=" + attendances +
                '}';
    }
}
