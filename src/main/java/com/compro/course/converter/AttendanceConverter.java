package com.compro.course.converter;

import com.compro.course.domain.Attendance;
import com.compro.course.dto.AttendanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AttendanceConverter {
    @Autowired
    CourseConverter courseConverter;
    public AttendanceResponse entityToDto(Attendance attendance) {
        AttendanceResponse attendanceResponse = new AttendanceResponse(attendance.getId(), attendance.getAttendance_type(), attendance.isAbsent(), attendance.getDate());
        attendanceResponse.setCourse(attendance.getCourse().getId());
        attendanceResponse.setBadge(attendance.getStudent_id());
        return attendanceResponse;
    }

    public List<AttendanceResponse> entityToDto(List<Attendance> attendanceList){
        return attendanceList.stream().map(this::entityToDto).collect(Collectors.toList());

    }
    public Attendance dtoToEntity(AttendanceResponse attendanceResponse) {
        Attendance attendance = new Attendance();
        attendance.setId(attendanceResponse.getId());
        attendance.setAttendance_type(attendanceResponse.getAttendance_type());
        attendance.setAbsent(attendanceResponse.isAbsent());
        attendance.setDate(attendanceResponse.getDate());
        attendance.setStudent_id(attendanceResponse.getBadge());
        return attendance;
    }
    public List<Attendance> DtoToEntity(List<AttendanceResponse> attendanceList){
        return attendanceList.stream().map(this::dtoToEntity).collect(Collectors.toList());

    }
}
