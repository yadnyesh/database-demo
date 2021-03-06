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
import com.in28minutes.database.databasedemo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class)
public class JPQLTest {

				private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;

	@Test
	public void	findById_basic() {
		List resultList = entityManager.createQuery("Select c From Course c").getResultList();
		logger.info("Select c From Course c -> {}", resultList);
	}

	@Test
	public void	findById_typed() {
		TypedQuery<Course> query = entityManager.createQuery("Select c From Course c", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Select c From Course c -> {}", resultList);
	}

	@Test
	public void	jpql_basic() {
//		Query query = entityManager.createNamedQuery("query_get_all_courses");
//		List<Course> resultList = query.getResultList();
//		logger.info("Select c From Course c -> {}", resultList)

		//Criteria query implementation

		//CriteriaBuilder to create a CriteriaQuery returning the expected
		//result object
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		//Define roots for tables involved inthe query
		Root<Course> courseRoot = cq.from(Course.class);

		TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));
		List<Course> resultList = query.getResultList();
		logger.info("Select c From Course c -> {}", resultList);
	}

	@Test
	public void	jpql_typed() {
		TypedQuery<Course> query = entityManager.createNamedQuery("query_get_all_courses", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Select c From Course c -> {}", resultList);
	}

	@Test
	public void	jpql_where() {
		TypedQuery<Course> query = entityManager.createNamedQuery("query_get_100_Step_courses", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("jpql_where -> {}", resultList);
	}

	@Test
	public void	jpql_courses_without_students() {
		TypedQuery<Course> query = entityManager.createQuery("Select c from Course c where c.studentList is empty", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("jpql_where -> {}", resultList);
	}

	@Test
	public void	jpql_courses_with_atleast_2_students() {
		TypedQuery<Course> query = entityManager.createQuery("Select c from Course c where size(c.studentList) >= 2", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("jpql_where -> {}", resultList);
	}

	@Test
	@Transactional
	public void	jpql_students_with_passports_in_pattern() {
		TypedQuery<Student> query = entityManager.createQuery("Select s from Student s where s.passport.number like '%1234%' ", Student.class);
		List<Student> resultList = query.getResultList();
		logger.info("jpql_where -> {}", resultList);
	}

	@Test
	@Transactional
	public void join() {
		Query query = entityManager.createQuery("Select c, s from Course c LEFT JOIN c.studentList s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Size -> {}", resultList.size());
		for (Object[] result:resultList){
			logger.info("Course -> {}", result[0] );
			logger.info("Student -> {}", result[1] );
		}
	}

	@Test
	@Transactional
	public void cross_join() {
		Query query = entityManager.createQuery("Select c, s from Course c, Student s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Size -> {}", resultList.size());
		for (Object[] result:resultList){
			logger.info("Course -> {}", result[0] );
			logger.info("Student -> {}", result[1] );
		}
	}
}
