package com.snoopgame.application.api.controllers;

import com.snoopgame.application.Entities.Employee;
import com.snoopgame.application.Repositories.EmployeeRepository;
import com.snoopgame.application.objectsForJSON.Employees;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EmployeeRestController {
    private final EmployeeRepository employeeRepository;

    public EmployeeRestController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @GetMapping ("/employee/get")
    public Employees sendUsers(){
        Iterable<Employee> employees = employeeRepository.findAll();
        return new Employees(employees);
    }


}
