package com.compro.course.controller;

import com.compro.course.converter.CourseConverter;
import com.compro.course.domain.Course;
import com.compro.course.dto.CourseResponse;
import com.compro.course.dto.StudentResponse;
import com.compro.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseConverter courseConverter;

    @GetMapping("/")
    public List<CourseResponse> getAllCourse() {
        List<Course> courses = courseService.getALlCourses();
        return courseConverter.entityToDto(courses);
    }

    @GetMapping("/coursesavailable")
    public List<CourseResponse> getAllCourseAvailable() {
        List<Course> courses = courseService.getAllCoursesAvailable();
        return courseConverter.entityToDto(courses);
    }

    @PostMapping("/add")
    public void addCourse(@RequestBody CourseResponse courseResponse) {
        Course course1 = courseConverter.dtoToEntity(courseResponse);
        courseService.save(course1);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCourse(@RequestBody CourseResponse courseResponse, @PathVariable long id) {

        Optional<Course> courseOptional = courseService.findById(id);

        if (!courseOptional.isPresent())
            return ResponseEntity.notFound().build();
        Course course1 = courseConverter.dtoToEntity(courseResponse);
        course1.setId(id);
        courseService.save(course1);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/delete/{id}")
    void deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
    }

    @GetMapping("/{student_id}/taken")
    public List<CourseResponse> getCoursesByStudentId(@PathVariable String student_id) {
        List<CourseResponse> courseResponses = courseConverter.entityToDto(courseService.getAllCoursesByStudentId(student_id));
        return courseResponses;
    }

    @GetMapping("/past/{faculty_id}")
    public List<CourseResponse> getCoursesByFacultyIdBefore(@PathVariable String faculty_id) {
        return courseConverter.entityToDto(courseService.getAllCoursesByFacultyIdBefore(faculty_id));
    }

    @GetMapping("/future/{faculty_id}")
    public List<CourseResponse> getCoursesByFacultyIdAfter(@PathVariable String faculty_id) {
        return courseConverter.entityToDto(courseService.getAllCoursesByFacultyIdAfter(faculty_id));
    }


    @PostMapping("/ta/{course_id}")
    public ResponseEntity<Object> assignTa(@RequestBody StudentResponse studentResponse, @PathVariable long course_id) {
        Optional<Course> courseOptional = courseService.findById(course_id);
        if (!courseOptional.isPresent())
            return ResponseEntity.notFound().build();
        Course course1 = courseOptional.get();
        course1.setTA(studentResponse.getBadge());
        courseService.save(course1);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/register/{student_id}")
    public ResponseEntity<Object> RegisterCourse(@RequestBody CourseResponse courseResponse, @PathVariable String student_id) {

        Course course1 = courseConverter.dtoToEntity(courseResponse);
        course1.add_courseId_student_id(student_id);

        courseService.save(course1);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{student_id}/registered")
    public List<CourseResponse> getRegisteredCourses(@PathVariable String student_id) {
        List<Course> courses = courseService.getAllRegisteredCourse(student_id);
        if (courses.isEmpty()) {
            System.out.println("Empty No Course Registered");
        }
        return courseConverter.entityToDto(courses);
    }

    @GetMapping("/{course_id}/students")
    public Collection<String> getCourseStudents(@PathVariable long course_id) {
        Optional<Course> course1 = courseService.findById(course_id);
        if (!course1.isPresent())
            System.out.println("Not Found Course");
        Course course = course1.get();
        Collection<String> student_idList = course.get_courseId_student_id();
        return student_idList;
    }

    //USing Thyme Leaf view all courses avilable//
    @GetMapping(value = {"/courseAvailabe/list"})
    public ModelAndView ListAvailableCourses(ModelAndView modelAndView) {
        List<CourseResponse> courseResponses = courseConverter.
                entityToDto(courseService.getAllCoursesAvailable());
        modelAndView.addObject("courses", courseResponses);
        modelAndView.addObject("customersCount", courseResponses.size());
        modelAndView.setViewName("course/list");
        return modelAndView;
    }

    //USing Thyme Leaf delete a course//
    @PostMapping(value = "/delete/course/{course_id}")
    public String deleteCourseById(@PathVariable Long course_id) {
        courseService.deleteById(course_id);
        return "redirect:/coursesavailable";
    }


}

