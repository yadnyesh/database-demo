package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Course;
import com.in28minutes.database.databasedemo.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		Course course = courseRepository.findById(10001L);
		logger.info("Course Details: {}", course);
		courseRepository.save(new Course("Microservices in 100 steps"));
		//courseRepository.deleteById(10001L);

////		logger.info("All Users: {}", personJdbcDao.findAll());
////		logger.info("Deleting 10002: #rows {}",
////				personJdbcDao.deleteById(10002));
//		logger.info("Inserting 10004: #rows {}",
//				personJpaRepository.insert(new Person("Tara", "Berlin", new Date())));
//		logger.info("Updating 10003: #rows {}",
//				personJpaRepository.update(new Person(10003, "Name 3", "Berlin 3", new Date())));
//		logger.info("All Users: {}", personJpaRepository.findAll());
//		personJpaRepository.deleteById(10002);
	}
}
