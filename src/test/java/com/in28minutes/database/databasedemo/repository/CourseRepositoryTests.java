package com.in28minutes.database.databasedemo.repository;

//import com.in28minutes.database.databasedemo.JpaDemoApplication;
//import com.in28minutes.database.databasedemo.entity.Course;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.database.databasedemo.JpaDemoApplication;
import com.in28minutes.database.databasedemo.entity.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class)
public class CourseRepositoryTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository courseRepository;

	@Test
	public void findById_basic() {
		Course course = courseRepository.findById(10001L);
		//assert("JPA in 50 Steps".equals(course.getName()));
		logger.info("Tests are Running");
		Assert.assertEquals("JPA in 50 Steps",course.getName());
	}

	@Test
	@DirtiesContext
	public void deleteById_basic() {
		courseRepository.deleteById(10002L);
		Assert.assertNull(courseRepository.findById(10002L));
		//assert("JPA in 50 Steps".equals(course.getName()));
		logger.info("Tests for Delete by ID");
	}

}
