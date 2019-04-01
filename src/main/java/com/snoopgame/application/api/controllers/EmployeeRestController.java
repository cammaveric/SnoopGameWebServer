package com.snoopgame.application.api.controllers;

import com.snoopgame.application.Entities.Employee;
import com.snoopgame.application.Repositories.EmployeeRepository;
import com.snoopgame.application.objectsForJSON.Employees;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/employee")
@RestController
public class EmployeeRestController {
    private final EmployeeRepository employeeRepository;

    public EmployeeRestController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @GetMapping("/get")
    public Employees sendUsers() {
        Iterable<Employee> employees = employeeRepository.findAll();
        return new Employees(employees);
    }


}
