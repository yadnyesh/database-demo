package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.repository.CourseRepository;
import com.in28minutes.database.databasedemo.repository.StudentRepository;
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

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		//studentRepository.saveStudentWithPassport();
//		List<Review> reviewList = new ArrayList<>();
//		reviewList.add(new Review ("5", "Too Good Hands on Stuff"));
//		reviewList.add(new Review("5", "Hatsoff"));
//		courseRepository.addReviewsForCourse(10003L, reviewList);
		studentRepository.insertHardcodedStudentandCourse();
	}
}
