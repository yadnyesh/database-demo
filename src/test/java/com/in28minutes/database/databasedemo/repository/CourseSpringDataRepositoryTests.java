package com.in28minutes.database.databasedemo.repository;

import com.in28minutes.database.databasedemo.JpaDemoApplication;
import com.in28minutes.database.databasedemo.entity.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class)
public class CourseSpringDataRepositoryTests {

				private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseSpringDataRepository courseRepository;

	@Autowired
	EntityManager em;

	@Test
	public void findById_coursePresent(){
		Optional<Course> courseOptional = courseRepository.findById(10001L);
        Assert.assertTrue(courseOptional.isPresent());
		logger.info("Course Optional --> {}", courseOptional.isPresent());
	}

	@Test
	public void findById_courseNotPresent(){
		Optional<Course> courseOptional = courseRepository.findById(100001L);
        Assert.assertFalse(courseOptional.isPresent());
		logger.info("Course Optional --> {}", courseOptional.isPresent());
	}

    @Test
    public void playingAroundWithSpringDataRepository(){
        Course course = new Course("New Microservices in 400 steps");
	    courseRepository.save(course);
	    course.setName("400 Steps for Microservices");
        courseRepository.save(course);
        logger.info("All Courses -> {}", courseRepository.findAll());
        logger.info("Total Courses -> {}", courseRepository.count());
    }

	@Test
	public void playingAroundWithSpringDataRepositorySort(){
		PageRequest pageRequest = PageRequest.of(0, 3);
		Page<Course> firstPage = courseRepository.findAll(pageRequest);
		logger.info("First Page -> {}", firstPage.getContent());

		Pageable secondPageable = firstPage.nextPageable();
		Page<Course> secondPage = courseRepository.findAll(secondPageable);
		logger.info("Second Page -> {}", secondPage.getContent());

	}




}
