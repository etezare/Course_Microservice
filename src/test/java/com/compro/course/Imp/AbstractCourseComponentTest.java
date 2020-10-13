package com.compro.course.Imp;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
abstract class AbstractCourseComponentTest {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

}
