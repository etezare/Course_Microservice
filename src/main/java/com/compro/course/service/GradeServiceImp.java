package com.compro.course.service;
import com.compro.course.domain.Course;
import com.compro.course.domain.Grade;
import com.compro.course.dto.GradeResponse;
import com.compro.course.dto.StudentResponse;
import com.compro.course.repositry.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GradeServiceImp implements GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();    }


    public List<Grade> getGradesByStudentId(String id) {
        return gradeRepository.findAllByStudentid(id);
    }

    @Override
    public List<Grade> getGradeByCourseId(long course_id) {
        return gradeRepository.findAllByCourseId(course_id);
    }

    @Override
    public void save(Grade grade) {
        gradeRepository.save(grade);
    }


}

