package com.in28minutes.database.databasedemo.repository;

import com.in28minutes.database.databasedemo.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


/**
 * Created by z063407 on 9/19/17.
 */
@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public void deleteById(Long id) {
        em.remove(findById(id));
    }

    public Course save(Course course) {
        if(course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }
        return course;
    }

    public void playWithEntityManager() {
        Course course = new Course("Web servies in 100 steps");
        em.persist(course);
        course.setName("Web servies in 100 steps - Updated");

        //Entity manager will persist change due to the @Transactional annotation
    }
}
