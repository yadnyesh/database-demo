package com.in28minutes.database.databasedemo.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by z063407 on 9/24/17.
 */
@Entity
public class PartTimeEmployee extends Employee{
    private BigDecimal hourlyWage;

    public PartTimeEmployee() {
    }

    public PartTimeEmployee(String name, BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }
}
