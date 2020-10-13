package com.compro.course.controller;
import com.compro.course.converter.GradeConverter;
import com.compro.course.domain.Attendance;
import com.compro.course.domain.Course;
import com.compro.course.domain.Grade;
import com.compro.course.dto.AttendanceResponse;
import com.compro.course.dto.GradeResponse;
import com.compro.course.service.CourseService;
import com.compro.course.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class GradeController {
    @Autowired
    private GradeService gradeService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private GradeConverter gradeConverter;

    @GetMapping("/grades/allgrades")
    public List<GradeResponse> getAllGrades() {
      List<Grade>grades= gradeService.getAllGrades();
      return gradeConverter.entityToDto(grades);
    }


    @GetMapping("/grades/{student_id}")
    public List<GradeResponse>getGradesByStudentId(@PathVariable String student_id) {
       List<Grade>grades=gradeService.getGradesByStudentId(student_id);
       return gradeConverter.entityToDto(grades);
    }

    @PostMapping("/courses/{student_id}/grades/{course_id}")
    public void addGrade(@RequestBody GradeResponse gradeResponse,
                                          @PathVariable String student_id,
                         @PathVariable long course_id) {
        Optional<Course> course=courseService.findById(course_id);
        if(!course.isPresent()){
            System.out.println("Course Not Found");
        }
        Course course1=course.get();
        Grade grade=gradeConverter.dtoToEntity(gradeResponse);
        grade.setStudentid(student_id);
        grade.setCourse(course1);
        gradeService.save(grade);
    }
    @GetMapping("/courses/{course_id}/grades")
    public List<GradeResponse> getGradesStudents(@PathVariable  long course_id){
        Optional<Course> course1=courseService.findById(course_id);
        if(!course1.isPresent())
            System.out.println("Not Found Course");
        Course course=course1.get();
        List<Grade>grades=gradeService.getGradeByCourseId(course_id);
        return gradeConverter.entityToDto(grades);
    }


}
