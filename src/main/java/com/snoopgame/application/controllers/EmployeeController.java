package com.snoopgame.application.controllers;

import com.snoopgame.application.Entities.Employee;
import com.snoopgame.application.Repositories.EmployeeRepository;
import com.snoopgame.application.objectsForJSON.Employees;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping ("/employee/get")
    public Employees sendUsers(){
        //employeeRepository.save(new Employee("sadas","wqeq","ewr[ep"));
        Iterable<Employee> employees = employeeRepository.findAll();
        return new Employees(employees);
    }
}
