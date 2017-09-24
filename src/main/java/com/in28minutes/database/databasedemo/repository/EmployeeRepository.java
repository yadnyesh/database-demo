package com.in28minutes.database.databasedemo.repository;


import com.in28minutes.database.databasedemo.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


/**
 * Created by z063407 on 9/24/17.
 */
@Repository
@Transactional
public class EmployeeRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager employeeEntityManager;

    public void insertEmployee(Employee employee) {
        employeeEntityManager.persist(employee);
    }

    public List<Employee> retrieveAllEmployees(Long id) {
        return employeeEntityManager.
    }
}
