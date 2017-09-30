package com.in28minutes.database.databasedemo.repository;

import com.in28minutes.database.databasedemo.JpaDemoApplication;
import com.in28minutes.database.databasedemo.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
		logger.info("Course Optional --> {}", courseOptional.isPresent());
	}

	@Test
	public void findById_courseNotPresent(){
		Optional<Course> courseOptional = courseRepository.findById(100001L);
		logger.info("Course Optional --> {}", courseOptional.isPresent());
	}

}
