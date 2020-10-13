package com.compro.course.repositry;

import com.compro.course.domain.Course;
import com.compro.course.domain.Grade;
import com.compro.course.dto.StudentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
   List<Grade>findAllByStudentid(String id);
   List<Grade>findAllByCourseId(long id);

}
