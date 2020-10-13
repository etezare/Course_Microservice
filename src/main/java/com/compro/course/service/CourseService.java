package com.compro.course.service;
import com.compro.course.domain.Course;
import com.compro.course.dto.CourseResponse;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> getALlCourses();
    void save(Course course);
    Optional<Course> findById(long id);
//    Optional<Course> findByTAId(long id);
    void deleteById(Long id);
    List<Course>getAllCoursesByStudentId(String id);
    List<Course>getAllCoursesAvailable();

    List<Course> getAllCoursesByFacultyIdBefore(String id);

    List<Course> getAllCoursesByFacultyIdAfter(String id);
    List<Course>getAllRegisteredCourse(String id);

}
