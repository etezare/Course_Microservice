package com.compro.course.Imp;

import com.compro.course.domain.Course;
import com.compro.course.service.CourseService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional // Enables any database operations to rollback after each testing
public class CourseServiceImplTest extends AbstractCourseComponentTest {

    @Autowired
    private CourseService courseService;

    @Before
    public void setUp() {
        logger.info("CourseServiceImplTest started");
    }

    @After
    public void tearDown() {
        logger.info("CourseServiceImplTest completed");
    }

    @Test
    public void testGetAllCoursesAvailable() {
        List<Course> courses =courseService.getAllCoursesAvailable();
        Assert.assertNotNull("Failure: expected courses to be not null", courses);
        Assert.assertEquals("Failure: expected size", 1, courses.size());
    }

    @Test
    public void testGetCourseById() {
        Long courseId=new Long(1);
        Optional<Course> course1= courseService.findById(1L);
        Course course=course1.get();
        Assert.assertNotNull("Failure: expected course to be not null", course);
        Assert.assertEquals("Failure: expected courseId to match", courseId, course.getId());

    }



}
