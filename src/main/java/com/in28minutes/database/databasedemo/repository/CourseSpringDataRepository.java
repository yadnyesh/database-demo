package com.in28minutes.database.databasedemo.repository;

import com.in28minutes.database.databasedemo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by z063407 on 9/30/17.
 */
public interface CourseSpringDataRepository extends JpaRepository<Course, Long>{

    List<Course> findByName(String name);
}
