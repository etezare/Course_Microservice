package com.compro.course.converter;

import com.compro.course.domain.Attendance;
import com.compro.course.domain.Grade;
import com.compro.course.dto.AttendanceResponse;
import com.compro.course.dto.GradeResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GradeConverter {
    public GradeResponse entityToDto(Grade grade) {
        GradeResponse gradeResponse = new GradeResponse(grade.getId(),grade.getGrade());
        gradeResponse.setCourse(grade.getCourse().getId());
        gradeResponse.setStudentid(grade.getStudentid());
        return gradeResponse;
    }

    public List<GradeResponse> entityToDto(List<Grade> grades){
        return grades.stream().map(this::entityToDto).collect(Collectors.toList());

    }
    public Grade dtoToEntity(GradeResponse gradeResponse) {
    Grade grade=new Grade();
    grade.setGrade(gradeResponse.getGrade());
        return grade;
    }
    public List<Grade> DtoToEntity(List<GradeResponse> gradeResponses){
        return gradeResponses.stream().map(this::dtoToEntity).collect(Collectors.toList());

    }
}
