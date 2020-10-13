package com.compro.course.repositry;

import com.compro.course.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query(value =
            " SELECT * FROM `eacs544`.course c where c.start_date<CURDATE() ", nativeQuery = true)
    List<Course> findCoursesByFaculty_idBefore(String id);
    @Query(value =
            " SELECT * FROM `eacs544`.course c where c.start_date>CURDATE() ", nativeQuery = true)
    List<Course> findCoursesByFaculty_idAfter(String id);
    @Query(value =
            " SELECT * FROM `eacs544`.course c where c.start_date>CURDATE() ", nativeQuery = true)
    List<Course>findCoursesAvailable();
//    @Query(value =
//            " SELECT * FROM `eacs544`.registered_course_studentid r where r._course_id_student_id=id ", nativeQuery = true)

}
