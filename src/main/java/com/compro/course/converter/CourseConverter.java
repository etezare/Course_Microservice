package com.compro.course.converter;

import com.compro.course.domain.Course;
import com.compro.course.dto.CourseResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseConverter {
    public CourseResponse entityToDto(Course course) {
        CourseResponse courseResponse = new CourseResponse(course.getId(),course.getCourseId(),
                course.getTitle(),course.getBuilding(),course.getRoom(),course.getStart_date(),
                course.getEnd_date());
        courseResponse.setFaculty_id(course.getFaculty_id());
        courseResponse.setTA(course.getTA());
        return courseResponse;
    }

    public List<CourseResponse> entityToDto(List<Course> courses){
        return courses.stream().map(this::entityToDto).collect(Collectors.toList());

    }
    public Course dtoToEntity(CourseResponse courseResponse) {
        Course course=new Course(courseResponse.getCourseId(),courseResponse.getTitle(),
                courseResponse.getBuilding(),courseResponse.getRoom(),courseResponse.getStart_date()
                ,courseResponse.getEnd_date());
        course.setFaculty_id(courseResponse.getFaculty_id());
        course.setTA(courseResponse.getTA());
        return course;
    }
    public List<Course> DtoToEntity(List<CourseResponse> courseResponses){
        return courseResponses.stream().map(this::dtoToEntity).collect(Collectors.toList());

    }
}
