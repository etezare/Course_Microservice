package com.compro.course.service;
import com.compro.course.domain.Course;
import com.compro.course.domain.Grade;
import com.compro.course.repositry.CourseRepository;
import com.compro.course.repositry.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CourseServiceImp implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private GradeRepository gradeRepository;
    private Course course;

    @Override
    public List<Course> getALlCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public Optional<Course> findById(long id) {
        return courseRepository.findById(id);
    }

//    @Override
//    public Optional<Course> findByTAId(long id) {
//        return courseRepository.findCoursesByTA(id);
//    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public  List<Course>getAllCoursesByStudentId(String id){
        List<Grade>grades=gradeRepository.findAllByStudentid(id);
        List<Course>courses=new ArrayList<>();
        for(Grade grade:grades){
            Course course=grade.getCourse();
            courses.add(course);
        }
          return  courses;
        }

    @Override
    public List<Course> getAllCoursesAvailable() {
        return courseRepository.findCoursesAvailable();
    }

    @Override
    public List<Course> getAllCoursesByFacultyIdBefore(String id) {
        List<Course>courses=courseRepository.findCoursesByFaculty_idBefore(id);
        List<Course>courses1=new ArrayList<>();
        for(Course course:courses){
            if(course.getFaculty_id().equals(id)){
                courses1.add(course);
            }
        }
        return courses1;
    }
    @Override
    public List<Course> getAllCoursesByFacultyIdAfter(String id) {
        List<Course>courses=courseRepository.findCoursesByFaculty_idAfter(id);
        List<Course>courses1=new ArrayList<>();
        for(Course course:courses){
            if(course.getFaculty_id().equals(id)){
                courses1.add(course);
            }
        }
        return courses1;
    }

    @Override
    public List<Course> getAllRegisteredCourse(String id) {
        List<Course>courses=courseRepository.findAll();
        List<Course>courseRegistered=new ArrayList<>();
        for(Course course1:courses){
            for(String s:course1.get_courseId_student_id()){
                if(s.contentEquals(id)){
                    courseRegistered.add(course1);
                }

            }
        }
        return courseRegistered;
    }


}

