package com.snoopgame.application.controllers;

import com.snoopgame.application.Entities.Employee;
import com.snoopgame.application.Entities.Role;
import com.snoopgame.application.Entities.User;
import com.snoopgame.application.Repositories.EmployeeRepository;
import com.snoopgame.application.objectsForJSON.Employees;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

@Controller
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("employee/add")
    public String addEmployee(Employee employee, Map<String,Object> model){
        Employee employeeFromDb = employeeRepository.findByNameAndSurnameAndMiddleName(employee.getName(),employee.getSurname(),employee.getMiddleName());
        if (employeeFromDb != null) {
            model.put("message", "Employee already exists!");
            return "redirect:/main";
        }
        employeeRepository.save(employee);
        return "redirect:/main";
    }
    @PostMapping("employee/remove")
    public String removeEmployee(Employee employee, Map<String,Object> model){
        Employee employeeFromDb = employeeRepository.findByNameAndSurnameAndMiddleName(employee.getName(),employee.getSurname(),employee.getMiddleName());
        if (employeeFromDb == null) {
            model.put("message", "Employee not exists!");
            return "redirect:/main";
        }
        employeeRepository.delete(employeeFromDb);
        return "redirect:/main";
    }

}
