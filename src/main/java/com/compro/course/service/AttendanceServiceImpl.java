package com.compro.course.service;

import com.compro.course.domain.Attendance;
import com.compro.course.dto.AttendanceResponse;
import com.compro.course.repositry.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();   }

    @Override
    public void save(Attendance attendance) {
        attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> getAttendaceByCourseId(long course_id) {
        return attendanceRepository.findAllByCourseId(course_id);
    }

}
