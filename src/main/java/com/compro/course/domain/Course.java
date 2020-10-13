package com.compro.course.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseId;
    private String title;
    private String building;
    private int room;
    @Temporal(TemporalType.DATE)
    private Date start_date;
    @Temporal(TemporalType.DATE)
    private Date end_date;
    @OneToMany(mappedBy = "course",cascade = CascadeType.PERSIST)
    private Collection<Grade> grades;
    @OneToMany(mappedBy = "course",cascade = CascadeType.PERSIST)
    private Collection<Attendance>attendances=new ArrayList<>();
    @Column(name = "faculty_id",nullable = true)
    private String faculty_id;
    @Column(name = "ta_id",nullable = true)
    private String  TA;
    @ElementCollection
    @CollectionTable(name = "RegisteredCourseStudentID")
    private Collection<String> _courseId_student_id = new ArrayList<>();
    public Course() {
    }


    public Course(String courseId, String title, String building, int room, Date start_date, Date end_date) {
        this.title = title;
        this.courseId=courseId;
        this.building = building;
        this.room = room;
        this.start_date = start_date;
        this.end_date = end_date;
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

    public void RemoveAttendance(Attendance attendance) {
        if(!attendances.isEmpty()) {
            attendances.remove(attendance);
        }
    }

    public void addAttendance(Attendance attendance) {
        attendances.add(attendance);
    }
    public void RemoveGrade(Grade grade) {
        if(!grades.isEmpty()) {
            grades.remove(grade);
        }
    }

    public Collection<String> get_courseId_student_id() {
        return _courseId_student_id;
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

    public void addGrade(Grade grade) {
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
