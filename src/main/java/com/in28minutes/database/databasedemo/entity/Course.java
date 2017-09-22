package com.in28minutes.database.databasedemo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by z063407 on 9/19/17.
 */

@Entity
@NamedQueries(value = {@NamedQuery(name="query_get_all_courses", query = "Select c from Course c"),
        @NamedQuery(name="query_get_100_Step_courses", query = "Select c From Course c where name like '%100 Steps'")})


public class Course {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    protected Course() {

    }

    public Course(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
