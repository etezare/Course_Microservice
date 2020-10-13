package com.compro.course;

import com.compro.course.domain.Course;
import com.compro.course.domain.Grade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.GregorianCalendar;

@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
//		Course course=new Course("EA","Maclaughing",105,new GregorianCalendar(2011,10,11).getTime(),new GregorianCalendar(2012,10,11).getTime());
//		Grade grade=new Grade()
		SpringApplication.run(CourseApplication.class, args);
	}

}
