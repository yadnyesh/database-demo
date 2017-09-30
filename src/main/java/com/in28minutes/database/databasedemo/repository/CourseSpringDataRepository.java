package com.in28minutes.database.databasedemo.repository;

import com.in28minutes.database.databasedemo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by z063407 on 9/30/17.
 */
public interface CourseSpringDataRepository extends JpaRepository<Course, Long>{
}
