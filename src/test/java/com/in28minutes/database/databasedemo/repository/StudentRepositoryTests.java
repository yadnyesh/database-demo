package com.in28minutes.database.databasedemo.repository;

import com.in28minutes.database.databasedemo.JpaDemoApplication;
import com.in28minutes.database.databasedemo.entity.Passport;
import com.in28minutes.database.databasedemo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class)
public class StudentRepositoryTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EntityManager studentEntityManager;


	@Test
	@Transactional
	public void someTest() {
		Student student = studentEntityManager.find(Student.class, 20001L);

		Passport passport = student.getPassport();

		passport.setNumber("E123457");

		student.setName("Ranga - Updated");
	}

	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = studentEntityManager.find(Student.class, 20001L);
		logger.info("Student -> {}", student);
		logger.info("Passport -> {}", student.getPassport());

	}

	@Test
	@Transactional
	public void retrievePassportAndStudentDetails() {
		Passport passport = studentEntityManager.find(Passport.class, 40001L);
		logger.info("Passport -> {}", passport);
		logger.info("Student -> {}", passport.getStudent());

	}

}
