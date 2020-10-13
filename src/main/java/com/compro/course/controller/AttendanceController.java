package com.compro.course.controller;

import com.compro.course.converter.AttendanceConverter;
import com.compro.course.domain.Attendance;
import com.compro.course.domain.Course;
import com.compro.course.domain.Grade;
import com.compro.course.dto.AttendanceResponse;
import com.compro.course.dto.CourseResponse;
import com.compro.course.dto.GradeResponse;
import com.compro.course.service.AttendanceService;

import com.compro.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private AttendanceConverter attendanceConverter;
    @Autowired
    private CourseService courseService;

    @GetMapping("/getallattendances")
    public List<AttendanceResponse> getAllAttendance() {

        List<Attendance> attendances = attendanceService.getAllAttendance();
        return attendanceConverter.entityToDto(attendances);
    }

    @PostMapping("/courses/{badge_id}/attendances/{course_id}")
    public void addAttendanceCourseById(@RequestBody AttendanceResponse attendanceResponse,
                                        @PathVariable String badge_id,
                                       @PathVariable long course_id) {
        Optional<Course> courses = courseService.findById(course_id);
        Course course = courses.get();
        Attendance attendance=attendanceConverter.dtoToEntity(attendanceResponse);
        attendance.setStudent_id(badge_id);
        attendance.setCourse(course);
        attendanceService.save(attendance);

    }
    @GetMapping("/courses/{course_id}/attendances")
    public List<AttendanceResponse> getCourseStudents(@PathVariable  long course_id){
        Optional<Course> course1=courseService.findById(course_id);
        if(!course1.isPresent())
            System.out.println("Not Found Course");
        Course course=course1.get();
        List<Attendance>attendances=attendanceService.getAttendaceByCourseId(course_id);
        return attendanceConverter.entityToDto(attendances);
    }
}
