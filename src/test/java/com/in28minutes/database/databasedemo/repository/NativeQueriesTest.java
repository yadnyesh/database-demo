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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class)
public class NativeQueriesTest {

				private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;

	@Test
	public void	native_queries_basic() {
		Query query = entityManager.createNativeQuery("Select * from Course", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Select * From Course c -> {}", resultList);
	}


	@Test
	public void	native_queries_with_parameter() {
		Query query = entityManager.createNativeQuery("Select * from Course where id = ?", Course.class);
		query.setParameter(1, 10001L);
		List<Course> resultList = query.getResultList();
		logger.info("Select * From Course c -> {}", resultList);
	}

	@Test
	public void	native_queries_with__named_parameter() {
		Query query = entityManager.createNativeQuery("Select * from Course where id = :id", Course.class);
		query.setParameter("id", 10001L);
		List<Course> resultList = query.getResultList();
		logger.info("Select * From Course c -> {}", resultList);
	}

	@Test
	@Transactional
	public void	native_queries_to_update() {
		Query query = entityManager.createNativeQuery("Update Course set last_updated_date=sysdate()", Course.class);
		int noOfRowsUpdated = query.executeUpdate();
		logger.info("noOfRowsUpdated -> {}", noOfRowsUpdated);
	}
}
