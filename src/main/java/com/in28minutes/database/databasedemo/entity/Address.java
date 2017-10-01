package com.in28minutes.database.databasedemo.entity;

import javax.persistence.Embeddable;

/**
 * Created by z063407 on 10/2/17.
 */
@Embeddable
public class Address {
    private String line1;
    private String line2;
    private String city;

    public Address(String line1, String line2, String city) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
    }

    public Address() {
    }
}
