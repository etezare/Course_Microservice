package com.compro.course.service;

import com.compro.course.domain.Attendance;
import com.compro.course.dto.AttendanceResponse;

import java.util.List;


public interface AttendanceService {
    List<Attendance> getAllAttendance();

    void save(Attendance attendance);

    List<Attendance> getAttendaceByCourseId(long course_id);
}
