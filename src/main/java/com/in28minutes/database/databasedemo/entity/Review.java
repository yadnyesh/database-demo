package com.in28minutes.database.databasedemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by z063407 on 9/22/17.
 */
@Entity
public class Review {

    @Id
    private Long id;

    @Column(nullable = false)
    private String description;

    public Review() {
    }

    public Review(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}

