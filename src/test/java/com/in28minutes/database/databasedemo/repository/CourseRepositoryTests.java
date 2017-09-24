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
import com.in28minutes.database.databasedemo.entity.Review;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

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

	@Test
	@DirtiesContext
	public void save_basic() {
		Course course = courseRepository.findById(10001L);
		Assert.assertEquals("JPA in 50 Steps",course.getName());
		course.setName("JPA in 500 Steps");
		course = courseRepository.save(course);
		Assert.assertEquals("JPA in 500 Steps",course.getName());
	}

	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		courseRepository.playWithEntityManager();
	}

	@Test
	@Transactional
	public void retrieveReviewsForCourse() {
		Course course = courseRepository.findById(10003L);
		List<Review> reviewList = course.getReviews();
		logger.info("reviews -> {}", reviewList);
		//courseRepository.playWithEntityManager();
	}

}
