package com.in28minutes.database.databasedemo.repository;

import com.in28minutes.database.databasedemo.entity.Course;
import com.in28minutes.database.databasedemo.entity.Review;
import com.in28minutes.database.databasedemo.entity.ReviewRating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


/**
 * Created by z063407 on 9/19/17.
 */
@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;
    //Entity manager is the interface to PersistentContext

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
        Course course1 = new Course("Web servies in 100 steps");
        em.persist(course1);
        course1.setName("Web servies in 100 steps - Updated");

        Course course2 = findById(10002L);
        em.persist(course2);
        course2.setName("AngularJS in 100 steps - Updated");
        //Entity manager will persist change due to the @Transactional annotation
        // use em.detach(course) to detach the course object from Transaction
        //OR use em.clear()

        //Read from database using em.refresh(course1);
    }

    public void addReviewsForCourse() {
        Course course = findById(10003L);
        logger.info("course.getreviews() -> {}", course.getReviews());
        Review review = new Review(ReviewRating.FIVE, "Great Handson Stuff");
        Review review1 = new Review(ReviewRating.FIVE, "Awesome Stuff");
        course.addReview(review);
        review.setCourse(course);
        course.addReview(review1);
        review.setCourse(course);

        em.persist(review);
        em.persist(review1);
    }

    public void addReviewsForCourse(Long courseId, List<Review> reviewList) {
        Course course = findById(courseId);
        logger.info("course.getreviews() -> {}", course.getReviews());

        for (Review review:reviewList) {
            //course.addReview(review);
            review.setCourse(course);
            em.persist(review);
        }


    }
}
