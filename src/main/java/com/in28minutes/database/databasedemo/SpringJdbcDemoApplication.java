package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
//		logger.info("All Users: {}", personJdbcDao.findAll());
//		logger.info("User ID 10001: {}", personJdbcDao.findById(10001));
//		logger.info("Deleting 10002: #rows {}",
//				personJdbcDao.deleteById(10002));
//		logger.info("Inserting 10004: #rows {}",
//				personJdbcDao.insert(new Person(10004, "Tara", "Berlin", new Date())));
//		logger.info("Updating 10003: #rows {}",
//				personJdbcDao.update(new Person(10003, "Name 3", "Berlin 3", new Date())));
//		logger.info("All Users: {}", personJdbcDao.findAll());
	}
}
