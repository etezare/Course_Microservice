package com.compro.course.service;
import com.compro.course.domain.Course;
import com.compro.course.domain.Grade;
import com.compro.course.dto.GradeResponse;

import java.util.List;

public interface GradeService {
    List<Grade>getAllGrades();
    List<Grade> getGradesByStudentId(String id);
    List<Grade>getGradeByCourseId(long course_id);
    void save(Grade grade);
}
