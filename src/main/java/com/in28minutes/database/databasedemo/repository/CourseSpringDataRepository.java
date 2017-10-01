package com.in28minutes.database.databasedemo.repository;

import com.in28minutes.database.databasedemo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by z063407 on 9/30/17.
 */
@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long>{

    List<Course> findByName(String name);
    List<Course> findByNameOrderById(String name);

    //JPQL
//    @Query("Select c from Course where name like '%00 Steps' ")
//    List<Course> courseswith100Steps();

    //NativeQuery
//    @Query("Select * from Course where name like '%00 Steps' ")
//    List<Course> courseswith100StepsNativeQuery();

}
