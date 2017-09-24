package com.in28minutes.database.databasedemo.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by z063407 on 9/24/17.
 */
@Entity
public class FullTimeEmployee extends Employee{

    private BigDecimal salary;

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
