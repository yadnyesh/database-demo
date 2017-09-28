package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.FullTimeEmployee;
import com.in28minutes.database.databasedemo.entity.PartTimeEmployee;
import com.in28minutes.database.databasedemo.repository.CourseRepository;
import com.in28minutes.database.databasedemo.repository.EmployeeRepository;
import com.in28minutes.database.databasedemo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		employeeRepository.insertEmployee(new FullTimeEmployee("Jack", new BigDecimal("10000")));
		employeeRepository.insertEmployee(new PartTimeEmployee("Jill", new BigDecimal("50")));
		logger.info("All Employees () -> {}", employeeRepository.retrieveAllEmployees());

	}
}
