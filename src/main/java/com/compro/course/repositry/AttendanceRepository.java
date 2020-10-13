package com.compro.course.repositry;

import com.compro.course.domain.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
List<Attendance>findAllByCourseId(long course_id);
}
